package com.dani.pruebaidealista.ui.list

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.dani.domain.Ads
import com.dani.pruebaidealista.ApiApplication
import com.dani.pruebaidealista.R
import com.dani.pruebaidealista.databinding.ActivityAdsListBinding
import com.dani.pruebaidealista.ui.common.BaseFragment
import com.dani.pruebaidealista.utils.getViewModel

class MainFragment : BaseFragment() {

    private lateinit var navController: NavController
    private lateinit var component: AdsListActivityComponent
    private val viewModel by lazy { getViewModel {component.viewModel }}
    private var intPage = 0
    private lateinit var adapter: MainAdapter
    private lateinit var binding: ActivityAdsListBinding
    private var adsList = mutableListOf<Ads>()
    private var name: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle? ): View {
        binding = ActivityAdsListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()

        (activity as? AppCompatActivity)?.supportActionBar?.show()

        component = (activity?.application as ApiApplication).adComponent.plus(AdsListActivityModule())

        //This for simplification I have put it here
        context?.resources?.openRawResource(R.raw.adlist)?.let { viewModel.saveDefaultAdsList(it) }
        context?.resources?.openRawResource(R.raw.adinfo)?.let { viewModel.saveDefaultAdDetails(it) }

        binding.rvItems.layoutManager = GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, false)
        adapter = MainAdapter(adsList, viewModel::onItemClicked, viewModel::onItemClickedLong, viewModel::onChangeFavoriteState, ::reloadList)
        binding.rvItems.adapter = adapter

        binding.btnSearch.setOnClickListener {
            intPage = 0
            name = binding.editText.text.toString()
            viewModel.getAds(intPage, name)
        }

        viewModel.model.observe(viewLifecycleOwner, Observer(::updateUi))

    }

    private fun reloadList(){
        //Added functionality in case there are more items to be displayed
        /*
        intPage++
        viewModel.getAds(intPage, name)
        */
    }

    override fun loadData() {
        viewModel.getAds(intPage, name)
    }

    private fun updateUi(uiModel: MainViewModel.UiModel) {

        binding.itemLoading.loading.visibility = if (uiModel is MainViewModel.UiModel.Loading) View.VISIBLE else View.GONE

        when (uiModel) {
            is MainViewModel.UiModel.Content -> {
                adsList.clear()
                adsList.addAll(uiModel.items)
                adapter.notifyDataSetChanged()
            }

            is MainViewModel.UiModel.Navigation -> {
                //This is commented as there is only one element with id 1.
                //val action = MainFragmentDirections.actionMainFragmentToDetailFragment(uiModel.item.propertyCode)
                val action = MainFragmentDirections.actionMainFragmentToDetailXML(1)
                navController.navigate(action)
            }

            is MainViewModel.UiModel.NavigationLong -> {
                val action = MainFragmentDirections.actionMainFragmentToDetailCompose(1)
                navController.navigate(action)
            }

            MainViewModel.UiModel.Loading -> {}
                is MainViewModel.UiModel.ChangeFavoriteState -> {
                    adapter.notifyItemChanged(uiModel.position)
            }
        }
    }
}

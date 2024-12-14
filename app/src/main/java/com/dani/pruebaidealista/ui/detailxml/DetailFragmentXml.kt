package com.dani.pruebaidealista.ui.detailxml

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import com.dani.pruebaidealista.ApiApplication
import com.dani.pruebaidealista.databinding.ActivityAdsDetailBinding
import com.dani.pruebaidealista.ui.common.BaseFragment
import com.dani.pruebaidealista.utils.getViewModel

class DetailFragmentXml : BaseFragment() {

    private lateinit var component: AdsDetailComponent
    private val viewModel by lazy { getViewModel {component.viewModel }}

    private val args: DetailFragmentXmlArgs by navArgs()
    private lateinit var binding: ActivityAdsDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivityAdsDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        component = (activity?.application as ApiApplication).adComponent.plus(
            AdsDetailModule().apply { itemId = args.id }
        )

        binding.item = viewModel
        binding.lifecycleOwner = this

        viewModel.itemDetail.observe(viewLifecycleOwner) { newValue ->
            (activity as AppCompatActivity).supportActionBar?.title =
                newValue.operation + " : " + newValue.price + "€"
        }
    }
}

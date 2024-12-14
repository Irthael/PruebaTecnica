package com.dani.pruebaidealista.ui.detailcompose

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.fragment.navArgs
import coil.compose.AsyncImage
import com.dani.domain.AdDetails
import com.dani.pruebaidealista.ApiApplication
import com.dani.pruebaidealista.ui.common.BaseFragment
import com.dani.pruebaidealista.utils.getViewModel

class DetailFragment2 : BaseFragment() {

    private lateinit var component: AdsDetailComponent2
    private val viewModel by lazy { getViewModel {component.viewModel }}
    private val args: DetailFragment2Args by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        component = (activity?.application as ApiApplication).adComponent.plus(
            AdsDetailModule2().apply { itemId = args.id }
        )

        return ComposeView(requireContext()).apply {
            setContent {
                AdDetailScreen(viewModel)
            }
        }
    }
}

@Composable
fun AdDetailScreen(
    viewModel: DetailViewModelCompose
){
    val state by viewModel.state.collectAsState()

    AdDetailScreen(
        loading = state.loading,
        adItem = state.adItem
    )
}

@Composable
fun AdDetailScreen(loading: Boolean, adItem: Result<AdDetails?>){

    if (loading) {
        CircularProgressIndicator()
    }
    adItem.fold({ item ->
        if (item != null) {
            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ){
                item{
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = item.state,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(16.dp, 0.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Photos",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp, 0.dp)
                    )
                }
                item{
                    LazyRow(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        if (item.multimedia.images.isNotEmpty()){
                            itemsIndexed(item.multimedia.images){ index,  it ->

                                Box(modifier = Modifier
                                    .padding(4.dp)) {

                                    AsyncImage(
                                        model = it.url,
                                        contentDescription = it.localizedName,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier.fillMaxSize()
                                    )
                                    Text(
                                        text = "${index + 1} / ${item.multimedia.images.size}",
                                        style = MaterialTheme.typography.headlineSmall,
                                        modifier = Modifier
                                            .align(Alignment.BottomEnd)
                                            .background(Color.White.copy(alpha = 0.6f))
                                            .padding(4.dp)
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                }
                            }
                        }
                    }
                }

                item{
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = item.propertyComment,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp, 0.dp)
                    )
                }
            }
        }
    }) {  }
    //No more ad fields are painted but they would be painted here if necessary
}

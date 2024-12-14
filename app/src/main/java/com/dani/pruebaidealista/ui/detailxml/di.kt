package com.dani.pruebaidealista.ui.detailxml

import com.dani.domain.usecase.GetAdInfoServerUseCase
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AdsDetailModule {

    var itemId: Int = 0

    @Provides
    fun adsDetailViewModelProvider(getAdDetailUseCase: GetAdInfoServerUseCase)
            = DetailViewModelXml(itemId, getAdDetailUseCase)
}

@Subcomponent(modules = [(AdsDetailModule::class)])
interface AdsDetailComponent {
    val viewModel: DetailViewModelXml
}

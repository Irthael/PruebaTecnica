package com.dani.pruebaidealista.ui.detailcompose

import com.dani.domain.usecase.GetAdInfoServerComposeUseCase
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AdsDetailModule2() {

    var itemId: Int = 0

    @Provides
    fun adsDetailViewModelProvider(getAdDetailUseCase: GetAdInfoServerComposeUseCase)
            = DetailViewModelCompose(itemId, getAdDetailUseCase)
}

@Subcomponent(modules = [(AdsDetailModule2::class)])
interface AdsDetailComponent2 {
    val viewModel: DetailViewModelCompose
}

package com.dani.pruebaidealista.ui.list

import com.dani.domain.usecase.GetAdListUseCase
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AdsListActivityModule {

    @Provides
    fun adsListViewModelProvider(getAdListUseCase: GetAdListUseCase)
            = MainViewModel(getAdListUseCase)
}

@Subcomponent(modules = [(AdsListActivityModule::class)])
interface AdsListActivityComponent {
    val viewModel: MainViewModel
}

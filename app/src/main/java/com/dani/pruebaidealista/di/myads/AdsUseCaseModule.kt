package com.dani.pruebaidealista.di.myads

import com.dani.domain.IAdRepository
import com.dani.domain.usecase.GetAdInfoLocalUseCase
import com.dani.domain.usecase.GetAdInfoServerComposeUseCase
import com.dani.domain.usecase.GetAdInfoServerUseCase
import com.dani.domain.usecase.GetAdListFilterUseCase
import com.dani.domain.usecase.GetAdListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AdsUseCaseModule {

    @Provides
    fun getItemsLocalProvider(itemsRepository: IAdRepository) = GetAdInfoLocalUseCase(itemsRepository)

    @Provides
    fun getItemsServerProvider(itemsRepository: IAdRepository) = GetAdInfoServerUseCase(itemsRepository)

    @Provides
    fun getItemsServerComposeProvider(itemsRepository: IAdRepository) = GetAdInfoServerComposeUseCase(itemsRepository)

    @Provides
    fun getItemsListProvider(itemsRepository: IAdRepository) = GetAdListUseCase(itemsRepository)

    @Provides
    fun getItemsListFilterProvider(itemsRepository: IAdRepository) = GetAdListFilterUseCase(itemsRepository)
}

package com.dani.pruebaidealista.di.myads

import com.dani.data.repository.AdRepository
import com.dani.data.source.LocalDataSource
import com.dani.data.source.RemoteDataSource
import com.dani.domain.IAdRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AdsDataModule {
    @Provides
    fun itemsRepositoryProvider(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource
    ) :IAdRepository = AdRepository(localDataSource, remoteDataSource)
}
package com.dani.pruebaidealista.di.myads

import com.dani.data.source.LocalDataSource
import com.dani.data.source.RemoteDataSource
import com.dani.pruebaidealista.model.APIServiceManager
import com.dani.pruebaidealista.model.database.ApiAdsDatabase
import com.dani.pruebaidealista.model.myads.RetrofitDataSource
import com.dani.pruebaidealista.model.myads.RoomDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AdsAppModule {

    @Provides
    fun localDataSourceProvider(db: ApiAdsDatabase): LocalDataSource = RoomDataSource(db)

    @Provides
    fun remoteDataSourceProvider(apiServiceManager: APIServiceManager): RemoteDataSource
            = RetrofitDataSource(apiServiceManager)
}

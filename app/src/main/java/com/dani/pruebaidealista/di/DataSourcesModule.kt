package com.dani.pruebaidealista.di

import android.app.Application
import androidx.room.Room
import com.dani.pruebaidealista.model.APIServiceManager
import com.dani.pruebaidealista.model.database.ApiAdsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
open class DataSourcesModule {

    @Provides @Singleton
    fun databaseProvider(app: Application): ApiAdsDatabase = Room.databaseBuilder(
        app,
        ApiAdsDatabase::class.java,
        "api_db"
    ).build()

    @Provides
    @Singleton
    @Named("baseUrl")
    fun baseUrlProvider(): String = "https://pruebaidealista.com/api/"

    @Provides
    @Singleton
    fun pruebaIdealistaServiceManagerProvider(@Named("baseUrl") baseUrl: String): APIServiceManager
            = APIServiceManager(baseUrl)
}

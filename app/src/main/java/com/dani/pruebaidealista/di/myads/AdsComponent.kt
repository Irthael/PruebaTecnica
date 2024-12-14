package com.dani.pruebaidealista.di.myads

import android.app.Application
import com.dani.pruebaidealista.di.DataSourcesModule
import com.dani.pruebaidealista.ui.detailxml.AdsDetailComponent
import com.dani.pruebaidealista.ui.detailxml.AdsDetailModule
import com.dani.pruebaidealista.ui.detailcompose.AdsDetailComponent2
import com.dani.pruebaidealista.ui.detailcompose.AdsDetailModule2
import com.dani.pruebaidealista.ui.list.AdsListActivityComponent
import com.dani.pruebaidealista.ui.list.AdsListActivityModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AdsAppModule::class,
    AdsDataModule::class,
    AdsUseCaseModule::class,
    DataSourcesModule::class
])

interface AdsComponent {

    fun plus(itemsListActivityModule: AdsListActivityModule): AdsListActivityComponent
    fun plus(itemsDetailActivityModule: AdsDetailModule): AdsDetailComponent
    fun plus(itemsDetailActivityModule2: AdsDetailModule2): AdsDetailComponent2

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): AdsComponent
    }
}

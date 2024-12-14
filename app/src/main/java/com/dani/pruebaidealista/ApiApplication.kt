package com.dani.pruebaidealista

import android.app.Application
import com.dani.pruebaidealista.di.myads.AdsComponent
import com.dani.pruebaidealista.di.myads.DaggerAdsComponent

open class ApiApplication : Application() {

    lateinit var adComponent: AdsComponent
        private set

    override fun onCreate() {
        super.onCreate()
        adComponent = DaggerAdsComponent.factory().create(this)
    }
}

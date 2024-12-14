package com.dani.data.source

import com.dani.domain.AdDetails
import com.dani.domain.Ads

interface LocalDataSource {
    suspend fun getAllAds(): List<Ads>
    suspend fun updateAds(item: Ads)
    suspend fun saveAds(list: List<Ads>)
    suspend fun getAdsByName(name: String): List<Ads>

    suspend fun saveAdsDetail(item: AdDetails)
    suspend fun getAdById(adID: Int): AdDetails
}



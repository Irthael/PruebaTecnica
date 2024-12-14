package com.dani.pruebaidealista.model.myads

import com.dani.data.source.LocalDataSource
import com.dani.domain.AdDetails
import com.dani.domain.Ads
import com.dani.pruebaidealista.model.database.ApiAdsDatabase
import com.dani.pruebaidealista.model.database.entities.AdsEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.dani.domain.Ads as AdsDomain

class RoomDataSource(database: ApiAdsDatabase) : LocalDataSource {

    private val dao = database.apiAdsDao()

    override suspend fun saveAds(list: List<Ads>) = withContext(Dispatchers.IO) {
        dao.insertAd(list.map(AdsDomain::toAdsEntity))
    }

    override suspend fun getAllAds(): List<AdsDomain> = withContext(Dispatchers.IO){
        dao.getAllAds().map(AdsEntity::toAdsDomain)
    }

    override suspend fun updateAds(item: Ads) = withContext(Dispatchers.IO){
        dao.updateAds(item.toAdsEntity())
    }

    override suspend fun getAdsByName(name: String): List<AdsDomain> = withContext(Dispatchers.IO){
        dao.getAllAdsByName(name).map(AdsEntity::toAdsDomain)
    }

    override suspend fun saveAdsDetail(item: AdDetails) = withContext(Dispatchers.IO) {
        dao.insertAdDetail(item.toAdDetailEntity())
    }

    override suspend fun getAdById(adID: Int) = withContext(Dispatchers.IO) {
        dao.getAdById(adID).toAdDetailDomain()
    }
}
package com.dani.domain

interface IAdRepository {

    suspend fun setAdsList(list: List<Ads>)

    suspend fun setAdDetail(item: AdDetails)

    suspend fun getAdsList(page: Int): List<Ads>

    suspend fun setUpdateAd(item: Ads)

    suspend fun getAdsListFilter(offset: Int, name: String): List<Ads>

    suspend fun findAdById(adID: Int): AdDetails

    suspend fun findAdByIdInServer(adID: Int): AdDetails?

    suspend fun findAdByIdInServerCompose(adID: Int): Result<AdDetails?>
}

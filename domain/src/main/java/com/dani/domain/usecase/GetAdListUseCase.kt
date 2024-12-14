package com.dani.domain.usecase

import com.dani.domain.AdDetails
import com.dani.domain.Ads
import com.dani.domain.IAdRepository

class GetAdListUseCase(private val adRepository: IAdRepository) {
    suspend fun setAdsList(list: List<Ads>) = adRepository.setAdsList(list)
    suspend fun setAdsDetails(item: AdDetails) = adRepository.setAdDetail(item)
    suspend fun setUpdateAd(item: Ads) = adRepository.setUpdateAd(item)
    suspend fun getNormalList(offset: Int): List<Ads> = adRepository.getAdsList(offset)
    suspend fun getListFilter(offset: Int, name: String): List<Ads> =
        adRepository.getAdsListFilter(offset, name)
}

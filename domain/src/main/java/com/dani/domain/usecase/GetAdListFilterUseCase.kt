package com.dani.domain.usecase

import com.dani.domain.Ads
import com.dani.domain.IAdRepository

class GetAdListFilterUseCase(private val adRepository: IAdRepository) {
    suspend fun invoke(offset: Int, name: String): List<Ads> =
        adRepository.getAdsListFilter(offset, name)
}

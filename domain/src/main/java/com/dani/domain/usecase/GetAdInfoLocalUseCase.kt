package com.dani.domain.usecase

import com.dani.domain.AdDetails
import com.dani.domain.IAdRepository

class GetAdInfoLocalUseCase(private val adRepository: IAdRepository) {
    suspend fun invoke(itemID: Int): AdDetails = adRepository.findAdById(itemID)
}

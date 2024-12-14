package com.dani.domain.usecase

import com.dani.domain.AdDetails
import com.dani.domain.IAdRepository

class GetAdInfoServerUseCase(private val adRepository: IAdRepository) {
    suspend fun invoke(adID: Int): AdDetails? = adRepository.findAdByIdInServer(adID)
}

package com.dani.domain.usecase

import com.dani.domain.AdDetails
import com.dani.domain.IAdRepository

class GetAdInfoServerComposeUseCase(private val adRepository: IAdRepository) {
    suspend fun invoke(adID: Int): Result<AdDetails?> = adRepository.findAdByIdInServerCompose(adID)
}

package com.dani.data.source

import com.dani.data.repository.Result
import com.dani.domain.AdDetails
import com.dani.domain.Ads

interface RemoteDataSource {
    suspend fun getAdsList(page: Int): Result<List<Ads>>
    suspend fun getAdFilterList(page: Int, name: String): Result<List<Ads>>
    suspend fun getAdInfo(adID: Int): Result<AdDetails?>
}
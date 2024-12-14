package com.dani.pruebaidealista.model.myads

import com.dani.data.repository.Result
import com.dani.data.source.RemoteDataSource
import com.dani.domain.AdDetails
import com.dani.domain.Ads
import com.dani.pruebaidealista.model.APIServiceManager

class RetrofitDataSource(private val apiServiceManager: APIServiceManager): RemoteDataSource {

    override suspend fun getAdsList(page: Int): Result<List<Ads>> {
        return try {
            val itemsResponse = apiServiceManager.service.getAllAds(actualPage = page)
            if (itemsResponse.isSuccessful) {
                Result.Success(itemsResponse.body()?.results ?: emptyList())
            } else {
                Result.Error("Error en la respuesta: ${itemsResponse.code()} - ${itemsResponse.message()}")
            }
        } catch (e: Exception) {
            Result.Error("Error en la llamada")
        }
    }

    override suspend fun getAdFilterList(page: Int, name: String): Result<List<Ads>> {
        return try {
            val itemsResponse = apiServiceManager.service.getAlladsFilter(actualPage = page, adName = name)
            return if (itemsResponse.isSuccessful){
                Result.Success(itemsResponse.body()?.results?: emptyList())
            }else{
                Result.Error("Sin elementos")
            }
        } catch (e: Exception) {
            Result.Error("Error en la llamada")
        }
    }

    override suspend fun getAdInfo(adID: Int): Result<AdDetails?> {
        return try {
            val itemsResponse = apiServiceManager.service.getAdsInfo( adID = adID)
            return if (itemsResponse.isSuccessful){
                Result.Success(itemsResponse.body())
            }else{
                Result.Error("Sin elementos")
            }
        } catch (e: Exception) {
            Result.Error("Error en la llamada")
        }
    }
}

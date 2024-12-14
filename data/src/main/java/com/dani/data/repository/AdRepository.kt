package com.dani.data.repository

import com.dani.data.source.LocalDataSource
import com.dani.data.source.RemoteDataSource
import com.dani.domain.AdDetails
import com.dani.domain.Ads
import com.dani.domain.IAdRepository

sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val message: String) : Result<Nothing>()
}

class AdRepository(private val localDataSourceAds: LocalDataSource,
                   private val remoteDataSourceAds: RemoteDataSource) : IAdRepository {

    override suspend fun setAdsList(list: List<Ads>)  {
        if (localDataSourceAds.getAllAds().isEmpty()) {
            localDataSourceAds.saveAds(list)
        }
    }

    override suspend fun setAdDetail(item: AdDetails)  {
       localDataSourceAds.saveAdsDetail(item)
    }

    override suspend fun getAdsList(page: Int): List<Ads> {

        when (val result = remoteDataSourceAds.getAdsList(page)) {
            is Result.Success -> {
                val adList = result.data
                localDataSourceAds.saveAds(adList)
            }
            is Result.Error -> {
            }
        }

        val newItems = localDataSourceAds.getAllAds()
        return newItems
    }

    override suspend fun setUpdateAd(item: Ads) {
        localDataSourceAds.updateAds(item)
    }

    override suspend fun getAdsListFilter(offset: Int, name: String): List<Ads> {
        when (val result = remoteDataSourceAds.getAdFilterList(offset, name)) {
            is Result.Success -> {
                val adList = result.data
                localDataSourceAds.saveAds(adList)
            }
            is Result.Error -> {
            }
        }
        return localDataSourceAds.getAdsByName(name)
    }

    override suspend fun findAdById(adID: Int): AdDetails =
        localDataSourceAds.getAdById(adID)

    override suspend fun findAdByIdInServer(adID: Int): AdDetails? {
        return when (val result = remoteDataSourceAds.getAdInfo(adID)) {
            is Result.Success -> {
                result.data
            }

            is Result.Error -> {
                localDataSourceAds.getAdById(adID)
            }
        }
    }

    override suspend fun findAdByIdInServerCompose(adID: Int): kotlin.Result<AdDetails?> {
        return when (val result = remoteDataSourceAds.getAdInfo(adID)) {
            is Result.Success -> {
                kotlin.Result.success(result.data)
            }

            is Result.Error -> {
                kotlin.Result.success(localDataSourceAds.getAdById(adID))
            }
        }
    }
}

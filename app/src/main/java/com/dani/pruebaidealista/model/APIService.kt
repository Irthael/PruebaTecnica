package com.dani.pruebaidealista.model

import com.dani.domain.AdDetails
import com.dani.domain.AdsListResponseData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {

    @GET("/api/ad")
    suspend fun getAllAds(
        @Query("page") actualPage: Int
    ): Response<AdsListResponseData>

    @GET("/api/ad")
    suspend fun getAlladsFilter(
        @Query("page") actualPage: Int,
        @Query("name") adName: String
    ): Response<AdsListResponseData>

    @GET("/api/ads/{adID}")
    suspend fun getAdsInfo(
        @Path("adID") adID: Int
    ): Response<AdDetails>
}

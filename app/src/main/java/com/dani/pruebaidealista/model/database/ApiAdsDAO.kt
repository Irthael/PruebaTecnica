package com.dani.pruebaidealista.model.database

import androidx.room.*
import com.dani.pruebaidealista.model.database.entities.AdDetailEntity
import com.dani.pruebaidealista.model.database.entities.AdsEntity

@Dao
interface ApiAdsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAd(itemList: List<AdsEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAdDetail(itemDetail: AdDetailEntity)

    @Query("SELECT * FROM AdsEntity")
    suspend fun getAllAds(): List<AdsEntity>

    @Query("SELECT * FROM AdsEntity WHERE address LIKE '%' || :name ||'%'")
    suspend fun getAllAdsByName(name: String): List<AdsEntity>

    @Query("SELECT * FROM AdDetailEntity WHERE adid = :id")
    suspend fun getAdById(id: Int): AdDetailEntity

    @Update
    suspend fun updateAds(ad: AdsEntity)

    @Delete
    suspend fun deleteAd(ad: AdsEntity)
}

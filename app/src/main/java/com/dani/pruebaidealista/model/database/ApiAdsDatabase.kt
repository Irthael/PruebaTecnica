package com.dani.pruebaidealista.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dani.pruebaidealista.model.database.entities.AdDetailEntity
import com.dani.pruebaidealista.model.database.entities.AdsEntity
import com.dani.pruebaidealista.utils.converter.EnergyCertificationConverter
import com.dani.pruebaidealista.utils.converter.FeaturesConverter
import com.dani.pruebaidealista.utils.converter.MultimediaConverter
import com.dani.pruebaidealista.utils.converter.ImagesConverter
import com.dani.pruebaidealista.utils.converter.MoreCharacteristicsConverter
import com.dani.pruebaidealista.utils.converter.PriceinfoConverter
import com.dani.pruebaidealista.utils.converter.TypeConverter
import com.dani.pruebaidealista.utils.converter.UbicationConverter

@Database(entities = [ AdsEntity::class, AdDetailEntity::class], version = 1, exportSchema = false)
@TypeConverters(FeaturesConverter::class, MultimediaConverter::class,
    ImagesConverter::class, PriceinfoConverter::class, UbicationConverter::class,
    EnergyCertificationConverter::class, TypeConverter::class, MoreCharacteristicsConverter::class)
abstract class ApiAdsDatabase : RoomDatabase() {
    abstract fun apiAdsDao(): ApiAdsDAO
}

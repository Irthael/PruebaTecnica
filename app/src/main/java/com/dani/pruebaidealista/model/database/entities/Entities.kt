package com.dani.pruebaidealista.model.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.dani.domain.EnergyCertification
import com.dani.domain.Features
import com.dani.domain.MoreCharacteristics
import com.dani.domain.Multimedia
import com.dani.domain.PriceInfo
import com.dani.domain.Ubication
import com.dani.pruebaidealista.utils.converter.EnergyCertificationConverter
import com.dani.pruebaidealista.utils.converter.FeaturesConverter
import com.dani.pruebaidealista.utils.converter.MoreCharacteristicsConverter
import com.dani.pruebaidealista.utils.converter.MultimediaConverter
import com.dani.pruebaidealista.utils.converter.PriceinfoConverter
import com.dani.pruebaidealista.utils.converter.UbicationConverter


//They are in a single file as there are only two classes, if there were more they would be in separate files.
@Entity
data class AdsEntity(
    @PrimaryKey (autoGenerate = false)
    val propertyCode: Int,
    val thumbnail: String,
    val floor: String,
    val price: Double,
    @TypeConverters(PriceinfoConverter::class)
    val priceInfo: PriceInfo,
    val propertyType: String,
    val operation: String,
    val size: Double,
    val exterior: Boolean,
    val rooms: Int,
    val bathrooms: Int,
    val address: String,
    val province: String,
    val municipality: String,
    val district: String,
    val country: String,
    val neighborhood: String,
    val latitude: Double,
    val longitude: Double,
    val description: String,
    @TypeConverters(MultimediaConverter::class)
    val multimedia: Multimedia,
    @TypeConverters(FeaturesConverter::class)
    val features: Features,
    val favorite: Boolean,
    val favoriteDate: Long
)

@Entity
data class AdDetailEntity(
    @PrimaryKey (autoGenerate = false)
    val adid: Int,
    val price: Double,
    @TypeConverters(PriceinfoConverter::class)
    val priceInfo: PriceInfo,
    val operation: String,
    val propertyType: String,
    val extendedPropertyType: String,
    val homeType: String,
    val state: String,
    @TypeConverters(MultimediaConverter::class)
    val multimedia: Multimedia,
    val propertyComment: String,
    @TypeConverters(UbicationConverter::class)
    val ubication: Ubication,
    val country: String,
    @TypeConverters(EnergyCertificationConverter::class)
    val energyCertification: EnergyCertification,
    @TypeConverters(MoreCharacteristicsConverter::class)
    val moreCharacteristics: MoreCharacteristics,
)

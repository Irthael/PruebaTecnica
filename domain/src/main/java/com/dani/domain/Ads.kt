package com.dani.domain

// They are in a single file as there are only two classes,
// if there were more they would be in separate files.
data class AdsListResponseData (
    val results: List<Ads>
)

data class Ads (
    val propertyCode: Int,
    val thumbnail: String,
    val floor: String,
    val price: Double,
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
    val multimedia: Multimedia,
    val features: Features,
    var favorite: Boolean,
    var favoriteDate: Long
)

data class PriceInfo (
    val amount: Double,
    val currencySuffix: String
)

data class Multimedia (
    val images: List<Images>
)
data class Images (
    val url: String,
    val tag: String,
    val localizedName: String?,
    val multimediaId: Long?,
)

data class Features (
    val hasAirConditioning: Boolean,
    val hasBoxRoom: Boolean
)

data class AdDetails (
    val adid: Int,
    val price: Double,
    val priceInfo: PriceInfo,
    val operation: String,
    val propertyType: String,
    val extendedPropertyType: String,
    val homeType: String,
    val state: String,
    val multimedia: Multimedia,
    val propertyComment: String,
    val ubication: Ubication,
    val country: String,
    val energyCertification: EnergyCertification,
    val moreCharacteristics: MoreCharacteristics,
)

data class Ubication (
    val latitude: Double,
    val longitude: Double
)

data class EnergyCertification (
    val title: String,
    val energyConsumption: Type,
    val emissions: Type,
)

data class Type (
    val type: String
)

data class MoreCharacteristics (
    val communityCosts: Double,
    val roomNumber: Int,
    val bathNumber: Int,
    val exterior: Boolean,
    val housingFurnitures: String,
    val agencyIsABank: Boolean,
    val energyCertificationType: String,
    val flatLocation: String,
    val modificationDate: Long,
    val constructedArea: Int,
    val lift: Boolean,
    val boxroom: Boolean,
    val isDuplex: Boolean,
    val floor: String,
    val status: String
)

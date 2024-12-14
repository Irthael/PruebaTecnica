package com.dani.pruebaidealista.model.myads

import com.dani.domain.*
import com.dani.pruebaidealista.model.database.entities.AdsEntity

fun AdsEntity.toAdsDomain(): Ads = Ads(
    propertyCode,
    thumbnail,
    floor,
    price,
    priceInfo,
    propertyType,
    operation,
    size,
    exterior,
    rooms,
    bathrooms,
    address,
    province,
    municipality,
    district,
    country,
    neighborhood,
    latitude,
    longitude,
    description,
    multimedia,
    features,
    favorite,
    favoriteDate
)

fun Ads.toAdsEntity(): AdsEntity =
    AdsEntity(
        propertyCode = this.propertyCode,
        thumbnail = this.thumbnail,
        floor = this.floor,
        price = this.price,
        priceInfo = this.priceInfo,
        propertyType = this.propertyType,
        operation = this.operation,
        size = this.size,
        exterior = this.exterior,
        rooms = this.rooms,
        bathrooms = this.bathrooms,
        address = this.address,
        province = this.province,
        municipality = this.municipality,
        district = this.district,
        country = this.country,
        neighborhood = this.neighborhood,
        latitude = this.latitude,
        longitude = this.longitude,
        description = this.description,
        multimedia = this.multimedia,
        features = this.features,
        favorite = this.favorite,
        favoriteDate = this.favoriteDate
    )

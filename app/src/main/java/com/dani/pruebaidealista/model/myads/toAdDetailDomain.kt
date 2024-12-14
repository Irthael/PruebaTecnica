package com.dani.pruebaidealista.model.myads

import com.dani.domain.*
import com.dani.pruebaidealista.model.database.entities.AdDetailEntity

fun AdDetailEntity.toAdDetailDomain(): AdDetails = AdDetails(
    adid,
    price,
    priceInfo,
    operation,
    propertyType,
    extendedPropertyType,
    homeType,
    state,
    multimedia,
    propertyComment,
    ubication,
    country,
    energyCertification,
    moreCharacteristics,
)

fun AdDetails.toAdDetailEntity(): AdDetailEntity =
    AdDetailEntity(
        adid = adid,
        price = price,
        priceInfo = priceInfo,
        operation = operation,
        propertyType = propertyType,
        extendedPropertyType = extendedPropertyType,
        homeType = homeType,
        state = state,
        multimedia = multimedia,
        propertyComment = propertyComment,
        ubication = ubication,
        country = country,
        energyCertification = energyCertification,
        moreCharacteristics = moreCharacteristics
    )

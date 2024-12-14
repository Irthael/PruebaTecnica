package com.dani.data

import com.dani.data.repository.AdRepository
import com.dani.data.source.LocalDataSource
import com.dani.data.source.RemoteDataSource
import com.dani.domain.AdDetails
import com.dani.domain.EnergyCertification
import com.dani.domain.MoreCharacteristics
import com.dani.domain.Multimedia
import com.dani.domain.PriceInfo
import com.dani.domain.Type
import com.dani.domain.Ubication
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class AdRepositoryTest {

    @Mock
    lateinit var localDataSource: LocalDataSource

    @Mock
    lateinit var remoteDataSource: RemoteDataSource

    lateinit var adRepository: AdRepository

    val adMock = AdDetails(
        adid = 0,
        price = 0.0,
        priceInfo = PriceInfo(0.0, ""),
        operation = "",
        propertyType = "",
        extendedPropertyType = "",
        homeType = "",
        state = "",
        multimedia = Multimedia(emptyList()),
        propertyComment = "",
        ubication = Ubication(0.0, 0.0),
        country = "",
        energyCertification = EnergyCertification("",
            Type(""),
            Type("")),
        moreCharacteristics = MoreCharacteristics(
            communityCosts = 0.0,
            roomNumber = 0,
            bathNumber = 0,
            exterior = false,
            housingFurnitures = "",
            agencyIsABank = false,
            energyCertificationType = "",
            flatLocation = "",
            modificationDate = 0L,
            constructedArea = 0,
            lift = false,
            boxroom = false,
            isDuplex = false,
            floor = "",
            status = ""
        )
    )

    @Before
    fun setUp() {
        localDataSource = mock()
        remoteDataSource = mock()
        adRepository = AdRepository(
            localDataSource,
            remoteDataSource
        )
    }

    @Test
    fun `get ad info from database with id`() = runTest {

        val localAd= adMock.copy()

        whenever(localDataSource.getAdById(0)).thenReturn(localAd)

        val result = adRepository.findAdById(0)

        assertEquals(localAd, result)

    }
}

package com.dani.usecase

import com.dani.domain.Ads
import com.dani.domain.IAdRepository
import com.dani.domain.usecase.GetAdListUseCase
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import kotlinx.coroutines.test.runTest
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetAdListUseCaseTest {

    @Mock
    lateinit var adRepository: IAdRepository
    lateinit var getAdListFilterUseCase: GetAdListUseCase
    lateinit var mockedAd : Ads

    @Before
    fun setUp() {
        mockedAd = mock()
        getAdListFilterUseCase = GetAdListUseCase(adRepository)
    }

    @Test
    fun `GetAdInfoServerUseCase getNormalList`() = runTest {
        val localAd = emptyList<Ads>()

        whenever(
            adRepository.getAdsList(
                ArgumentMatchers.anyInt()
            )
        ).thenReturn(emptyList())

        val result = getAdListFilterUseCase.getNormalList(0)

        assertEquals(localAd, result)
    }

    @Test
    fun `GetAdInfoServerUseCase getListFilter`() = runTest {
        val localAd = emptyList<Ads>()

        whenever(
            adRepository.getAdsListFilter(
                ArgumentMatchers.anyInt(),
                ArgumentMatchers.anyString()
            )
        ).thenReturn(emptyList())

        val result = getAdListFilterUseCase.getListFilter(0, "")

        assertEquals(localAd, result)
    }
}

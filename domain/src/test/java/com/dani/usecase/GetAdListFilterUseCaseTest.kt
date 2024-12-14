package com.dani.usecase

import com.dani.domain.Ads
import com.dani.domain.IAdRepository
import com.dani.domain.usecase.GetAdListFilterUseCase
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
class GetAdListFilterUseCaseTest {

    @Mock
    lateinit var adRepository: IAdRepository
    lateinit var getAdListFilterUseCase: GetAdListFilterUseCase
    lateinit var mockedAd : Ads

    @Before
    fun setUp() {
        mockedAd = mock()
        getAdListFilterUseCase = GetAdListFilterUseCase(adRepository)
    }

    @Test
    fun `invoke GetAdListFilterUseCase`() = runTest {
        val localAd = emptyList<Ads>()

        whenever(
            adRepository.getAdsListFilter(
                ArgumentMatchers.anyInt(),
                ArgumentMatchers.anyString()
            )
        ).thenReturn(emptyList())

        val result = getAdListFilterUseCase.invoke(0, "")

        assertEquals(localAd, result)
    }
}

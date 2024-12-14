package com.dani.usecase

import com.dani.domain.AdDetails
import com.dani.domain.IAdRepository
import com.dani.domain.usecase.GetAdInfoLocalUseCase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetAdInfoLocalUseCaseTest {

    @Mock
    lateinit var adRepository: IAdRepository
    lateinit var mockedAd : AdDetails
    lateinit var getAdInfoLocalUseCase: GetAdInfoLocalUseCase

    @Before
    fun setUp() {
        mockedAd = mock()
        getAdInfoLocalUseCase = GetAdInfoLocalUseCase(adRepository)
    }

    @Test
    fun `invoke GetAdInfoLocalUseCase`() = runTest {
        val localMyAd = mockedAd.copy()

        whenever(adRepository.findAdById(ArgumentMatchers.anyInt())).thenReturn(localMyAd)

        val result = getAdInfoLocalUseCase.invoke(1)

        assertEquals(localMyAd, result)
        verify(adRepository).findAdById(1)
    }
}
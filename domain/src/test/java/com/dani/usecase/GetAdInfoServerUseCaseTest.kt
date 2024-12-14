package com.dani.usecase

import com.dani.domain.AdDetails
import com.dani.domain.IAdRepository
import com.dani.domain.usecase.GetAdInfoServerUseCase
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import kotlinx.coroutines.test.runTest
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetAdInfoServerUseCaseTest {

    @Mock
    lateinit var adRepository: IAdRepository
    lateinit var getAdInfoServerUseCase: GetAdInfoServerUseCase
    lateinit var mockedAd : AdDetails

    @Before
    fun setUp() {
        mockedAd = mock()
        getAdInfoServerUseCase = GetAdInfoServerUseCase(adRepository)
    }

    @Test
    fun `invoke GetAdInfoServerUseCase`() = runTest {
        val localMyAd = mockedAd.copy()

        whenever(adRepository.findAdByIdInServer(ArgumentMatchers.anyInt()))
            .thenReturn(localMyAd)

        val result = getAdInfoServerUseCase.invoke(1)

        assertEquals(localMyAd, result)
        verify(adRepository).findAdByIdInServer(1)
    }
}

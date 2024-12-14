package com.dani.usecase

import com.dani.domain.AdDetails
import com.dani.domain.IAdRepository
import com.dani.domain.usecase.GetAdInfoServerComposeUseCase
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
class GetAdInfoServerComposeUseCaseTest {

    @Mock
    lateinit var adRepository: IAdRepository
    lateinit var getAdInfoServerComposeUseCase: GetAdInfoServerComposeUseCase
    lateinit var mockedAd : AdDetails

    @Before
    fun setUp() {
        mockedAd = mock()
        getAdInfoServerComposeUseCase = GetAdInfoServerComposeUseCase(adRepository)
    }

    @Test
    fun `invoke GetAdInfoServerComposeUseCase`() = runTest {
        val localMyAd = Result.success(mockedAd.copy())

        whenever(adRepository.findAdByIdInServerCompose(ArgumentMatchers.anyInt()))
            .thenReturn(localMyAd)

        val result = getAdInfoServerComposeUseCase.invoke(1)

        assertEquals(localMyAd, result)
        verify(adRepository).findAdByIdInServerCompose(1)
    }
}

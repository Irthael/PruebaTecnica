package com.dani.pruebaidealista.ui.detailcompose

import androidx.lifecycle.*
import com.dani.domain.AdDetails
import com.dani.domain.usecase.GetAdInfoServerComposeUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailViewModelCompose(private val itemId: Int,
                             private val getAdInfoServerComposeUseCase: GetAdInfoServerComposeUseCase
):
    ViewModel() {

    private val _state = MutableStateFlow(UiState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.value = UiState(loading = true)
            _state.value = UiState(adItem = getAdInfoServerComposeUseCase.invoke(itemId))
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val adItem: Result<AdDetails?> =
            Result.success(null)
    )
}

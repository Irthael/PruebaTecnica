package com.dani.pruebaidealista.ui.detailxml

import androidx.lifecycle.*
import com.dani.domain.AdDetails
import com.dani.domain.usecase.GetAdInfoServerUseCase
import kotlinx.coroutines.launch

class DetailViewModelXml(private val itemId: Int,
                         private val getItem: GetAdInfoServerUseCase
):
    ViewModel() {

    private val _ad = MutableLiveData<AdDetails>()

    val itemDetail: LiveData<AdDetails>
        get() {
            if (_ad.value == null) getAdInfo(itemId)
            return _ad
        }

    private fun getAdInfo(itemId: Int) = viewModelScope.launch {
        _ad.value = getItem.invoke(itemId)
    }
}

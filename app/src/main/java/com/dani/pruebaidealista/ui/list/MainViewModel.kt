package com.dani.pruebaidealista.ui.list

import androidx.lifecycle.*
import com.dani.domain.AdDetails
import com.dani.domain.Ads
import com.dani.pruebaidealista.utils.ReadJSONFromAssets
import com.dani.domain.usecase.GetAdListUseCase
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.InputStream
import java.util.Date

class MainViewModel(private val getAdListUseCase : GetAdListUseCase)
    : ViewModel() {

    sealed class UiModel {
        object Loading : UiModel()
        class Content(val items: List<Ads>): UiModel()
        class ChangeFavoriteState(val item: Ads, val position: Int): UiModel()
        class Navigation(val item: Ads): UiModel()
        class NavigationLong(val item: Ads): UiModel()
    }

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel> = _model

    fun saveDefaultAdsList(input: InputStream){
        viewModelScope.launch {
            val jsonString = ReadJSONFromAssets(input)
            val myList: MutableList<Ads> = Gson().fromJson(jsonString, object : TypeToken<List<Ads>>() {}.type)
            getAdListUseCase.setAdsList(myList.toList())
        }
    }

    fun saveDefaultAdDetails(input: InputStream){
        viewModelScope.launch {
            val itemDetail: AdDetails = Gson().fromJson(ReadJSONFromAssets(input), object : TypeToken<AdDetails>() {}.type)
            getAdListUseCase.setAdsDetails(itemDetail)
        }
    }

    fun getAds(page: Int, name: String){
        viewModelScope.launch {
            _model.value = UiModel.Loading
            if (name.isBlank() || name.isEmpty()){
                _model.value = UiModel.Content( getAdListUseCase.getNormalList(page) )
            } else {
                _model.value = UiModel.Content( getAdListUseCase.getListFilter(page, name) )
            }
        }
    }

    fun onItemClicked(item: Ads){
        _model.value =
            UiModel.Navigation(
                item
            )
    }

    fun onItemClickedLong(item: Ads){
        _model.value =
            UiModel.NavigationLong(
                item
            )
    }

    fun onChangeFavoriteState(item: Ads, position: Int){
        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                _model.value = UiModel.Loading
            }
            item.favorite = !item.favorite
            item.favoriteDate = Date().time
            getAdListUseCase.setUpdateAd(item)
            withContext(Dispatchers.Main) {
                _model.value = UiModel.ChangeFavoriteState(item, position)
            }
        }
    }
}

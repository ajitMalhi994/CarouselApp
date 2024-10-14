package com.example.carouselapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Params
import com.example.domain.usecase.CarouselItemsUseCase
import com.example.domain.usecase.ListItemsUseCase
import com.example.data.entity.Device
import com.example.data.entity.DeviceDescription
import com.example.domain.common.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val carouselItemsUseCase: CarouselItemsUseCase,
    private val listItemsUseCase: ListItemsUseCase
) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery get() = _searchQuery.asStateFlow()

    private val _carouselItemList = MutableStateFlow<Resource<List<Device>>>(Resource.loading())
    val carouselItemList get() = _carouselItemList.asStateFlow()

    private val _deviceItemList = MutableStateFlow<Resource<List<DeviceDescription>?>>(Resource.loading())
    val deviceItemList get() = _deviceItemList.asStateFlow()

    private var currentCarouselForDisplay = -1

    fun onCarouselChanged(index: Int) {
        currentCarouselForDisplay = index
        _searchQuery.value = ""
        getCatalogRange()
    }

    fun onSearchValueChange(query: String) {
        _searchQuery.value = query
        onSearchTriggered()
    }

    private fun onSearchTriggered() {
        getCatalogRange()
    }

    private fun getCatalogList() = viewModelScope.launch {
        carouselItemsUseCase.invoke(Unit).catch {
            _carouselItemList.emit(Resource.error(it))
        }.collect {
            _carouselItemList.emit(Resource.success(it))
        }
    }

    private fun getCatalogRange() = viewModelScope.launch {
        if (currentCarouselForDisplay < 0 || _carouselItemList.value.data?.isNotEmpty() == true) {
            return@launch
        }
        val catalogType = _carouselItemList.value.data?.get(currentCarouselForDisplay)?.type
        val param = Params(catalogType, searchQuery.value)
        listItemsUseCase.invoke(param).catch {
            _deviceItemList.emit(Resource.error(it))
        }.collect {
            _deviceItemList.emit(Resource.success(it))
        }
    }

    init {
        getCatalogList()
    }
}
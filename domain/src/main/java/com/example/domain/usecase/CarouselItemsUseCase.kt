package com.example.domain.usecase

import com.example.domain.common.BaseUseCase
import com.example.data.repository.DeviceRepo
import com.example.data.entity.Device
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CarouselItemsUseCase @Inject constructor(private val deviceRepo: DeviceRepo) :
    BaseUseCase<Unit, List<Device>>() {

    override suspend fun execute(params: Unit): Flow<List<Device>> {
        return deviceRepo.getCarouselItemList()
    }

    override val dispatcher: CoroutineDispatcher
        get() = Dispatchers.IO
}
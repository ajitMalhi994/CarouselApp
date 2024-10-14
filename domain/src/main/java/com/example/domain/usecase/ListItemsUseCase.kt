package com.example.domain.usecase

import com.example.domain.common.BaseUseCase
import com.example.domain.model.Params
import com.example.data.repository.DeviceRepo
import com.example.data.entity.DeviceDescription
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ListItemsUseCase @Inject constructor(private val deviceRepo: DeviceRepo) :
    BaseUseCase<Params, List<DeviceDescription>>() {

    override suspend fun execute(params: Params): Flow<List<DeviceDescription>> {
        return deviceRepo.getDeviceItemsList(params.deviceType)
            .map { responseList ->
                responseList.filter { item ->
                    item.title.contains(params.searchQuery ?: "", ignoreCase = true)
                }
            }

    }

    override val dispatcher: CoroutineDispatcher
        get() = Dispatchers.IO
}
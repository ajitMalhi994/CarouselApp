package com.example.data.repository

import com.example.data.local_data.LocalDeviceData
import com.example.data.entity.DeviceType
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DeviceRepoImpl @Inject constructor(private val devicesData: LocalDeviceData) :
    DeviceRepo {

    override suspend fun getCarouselItemList() = flow {
        emit(devicesData.deviceDataList)
    }

    override suspend fun getDeviceItemsList(deviceType: DeviceType?) = flow {
        val response = when (deviceType) {
            DeviceType.ANDROID -> devicesData.android
            DeviceType.IPHONE -> devicesData.iphone
            DeviceType.WINDOWS -> devicesData.windows
            else -> devicesData.android
        }
        emit(response)
    }
}
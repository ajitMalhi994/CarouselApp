package com.example.data.repository

import com.example.data.entity.Device
import com.example.data.entity.DeviceDescription
import com.example.data.entity.DeviceType
import kotlinx.coroutines.flow.Flow

interface DeviceRepo {
    suspend fun getCarouselItemList(): Flow<List<Device>>
    suspend fun getDeviceItemsList(deviceType: DeviceType?): Flow<List<DeviceDescription>>
}
package com.example.domain.di

import com.example.data.repository.DeviceRepo
import com.example.domain.usecase.CarouselItemsUseCase
import com.example.domain.usecase.ListItemsUseCase
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {

    @Singleton
    fun provideGetCarouselItemsUseCase(
        deviceRepo: DeviceRepo
    ): CarouselItemsUseCase {
        return CarouselItemsUseCase(deviceRepo)
    }

    @Singleton
    fun provideGetDeviceListItemsUseCase(
        deviceRepo: DeviceRepo
    ): ListItemsUseCase {
        return ListItemsUseCase(deviceRepo)
    }
}

package com.example.domain.di

import com.example.data.repository.DeviceRepo
import com.example.data.repository.DeviceRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Binds
    abstract fun provideCarouselRepository(deviceRepoImpl: DeviceRepoImpl): DeviceRepo
}

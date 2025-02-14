package com.example.data.di

import com.example.data.local_data.LocalDeviceData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideDataStore(): LocalDeviceData {
        return LocalDeviceData()
    }
}
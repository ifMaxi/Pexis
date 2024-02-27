package com.maxidev.pexis.di

import com.maxidev.pexis.data.remote.PexisApiService
import com.maxidev.pexis.data.repository.impl.PhotosRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun providesCuratedRepository(apiService: PexisApiService): PhotosRepositoryImpl =
        PhotosRepositoryImpl(apiService)
}
package com.maxidev.pexis.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.maxidev.pexis.data.remote.ApiKeyInterceptor
import com.maxidev.pexis.data.remote.PexisApiService
import com.maxidev.pexis.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        val contentType = "application/json".toMediaType()
        val client = OkHttpClient.Builder()
            .addInterceptor(ApiKeyInterceptor())
            .build()
        val json = Json {
            ignoreUnknownKeys = true
        }

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            //.client(client)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
    }

    @Provides
    @Singleton
    fun providesApiService(retrofit: Retrofit): PexisApiService =
        retrofit.create(PexisApiService::class.java)
}
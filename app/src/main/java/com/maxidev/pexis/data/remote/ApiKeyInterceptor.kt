package com.maxidev.pexis.data.remote

import com.maxidev.pexis.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor: Interceptor {
    private val apiKey = BuildConfig.Authorization

    override fun intercept(chain: Interceptor.Chain): Response {
        var original = chain.request()
        val url = original.url
            .newBuilder()
            .addQueryParameter("Authorization: ", apiKey)
            .build()

        original = original
            .newBuilder()
            .url(url)
            .build()

        return chain.proceed(original)
    }
}
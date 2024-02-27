package com.maxidev.pexis.data.remote

import com.maxidev.pexis.BuildConfig
import com.maxidev.pexis.data.remote.model.photo_search.Photos
import com.maxidev.pexis.data.remote.model.photo_search.SearchPhoto
import com.maxidev.pexis.utils.Constants.CURATED
import com.maxidev.pexis.utils.Constants.SEARCH
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface PexisApiService {

    // Get a selection of photos by the pexels team.
    // The "perPage" parameter will display photos according to the desired quantity.
    @Headers("Authorization: ${BuildConfig.Authorization}")
    @GET(CURATED)
    suspend fun getCuratedPhotos(
        @Query("per_page") perPage: Int,
        @Query("page") page: Int
    ): Photos

    @Headers("Authorization: ${BuildConfig.Authorization}")
    @GET(SEARCH)
    suspend fun getSearchPhotos(
        @Query("query") query: String,
        @Query("per_page") perPage: Int,
        @Query("page") page: Int
    ): SearchPhoto
}
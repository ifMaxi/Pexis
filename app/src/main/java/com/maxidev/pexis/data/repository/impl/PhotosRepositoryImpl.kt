package com.maxidev.pexis.data.repository.impl

import com.maxidev.pexis.data.remote.PexisApiService
import com.maxidev.pexis.data.remote.model.photo_search.Photos
import com.maxidev.pexis.data.remote.model.photo_search.SearchPhoto
import com.maxidev.pexis.data.repository.PhotosRepository
import javax.inject.Inject

class PhotosRepositoryImpl @Inject constructor(
    private val apiService: PexisApiService
): PhotosRepository {
    override suspend fun getCuratedPhotos(perPage: Int, page: Int): Photos =
        apiService.getCuratedPhotos(perPage, page)

    override suspend fun getSearchedPhotos(
        query: String,
        perPage: Int,
        page: Int
    ): SearchPhoto =
        apiService.getSearchPhotos(query, perPage, page)
}
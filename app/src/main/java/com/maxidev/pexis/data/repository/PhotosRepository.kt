package com.maxidev.pexis.data.repository

import com.maxidev.pexis.data.remote.model.photo_search.Photos
import com.maxidev.pexis.data.remote.model.photo_search.SearchPhoto

interface PhotosRepository {
    suspend fun getCuratedPhotos(perPage: Int, page: Int): Photos

    suspend fun getSearchedPhotos(query: String, perPage: Int, page: Int): SearchPhoto
}
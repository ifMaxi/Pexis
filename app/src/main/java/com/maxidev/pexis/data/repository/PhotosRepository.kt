package com.maxidev.pexis.data.repository

import androidx.paging.PagingData
import com.maxidev.pexis.data.remote.model.photo_search.Photo
import kotlinx.coroutines.flow.Flow

interface PhotosRepository {
    fun getCuratedPhotos(perPage: Int, page: Int): Flow<PagingData<Photo>>

    fun getSearchedPhotos(query: String, perPage: Int, page: Int): Flow<PagingData<Photo>>
}
package com.maxidev.pexis.data.repository.impl

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.filter
import com.maxidev.pexis.data.remote.PexisApiService
import com.maxidev.pexis.data.remote.model.photo_search.Photo
import com.maxidev.pexis.data.repository.PhotosRepository
import com.maxidev.pexis.data.repository.datasource.PhotoPagingSource
import com.maxidev.pexis.data.repository.datasource.SearchPhotoPagingSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PhotosRepositoryImpl @Inject constructor(
    private val apiService: PexisApiService
): PhotosRepository {
    private fun pagingConfig(perPage: Int) = PagingConfig(
        pageSize = perPage,
        enablePlaceholders = false,
        prefetchDistance = 1
    )

    override fun getCuratedPhotos(perPage: Int, page: Int): Flow<PagingData<Photo>> =
        Pager(
            config = pagingConfig(perPage),
            pagingSourceFactory = {
                PhotoPagingSource(
                    backend = apiService
                )
            }
        ).flow
            .map {
                val filteredImg = mutableSetOf<Int>()

                it.filter { image ->
                    if (filteredImg.contains(image.id)) {
                        false
                    } else {
                        filteredImg.add(image.id)
                    }
                }
            }

    override fun getSearchedPhotos(
        query: String,
        perPage: Int,
        page: Int
    ): Flow<PagingData<Photo>> =
        Pager(
            config = pagingConfig(perPage),
            pagingSourceFactory = {
                SearchPhotoPagingSource(
                    backend = apiService,
                    query = query
                )
            }
        ).flow
            .map {
                val filteredImg = mutableSetOf<Int>()

                it.filter { img ->
                    if (filteredImg.contains(img.id)) {
                        false
                    } else {
                        filteredImg.add(img.id)
                    }
                }
            }
}
package com.maxidev.pexis.ui.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.filter
import com.maxidev.pexis.data.repository.datasource.PhotoPagingSource
import com.maxidev.pexis.data.repository.impl.PhotosRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class PhotosCuratedViewModel @Inject constructor(
    private val repository: PhotosRepositoryImpl
): ViewModel() {

    val flowImage = Pager(
        config = PagingConfig(
            pageSize = 1,
            enablePlaceholders = false,
            prefetchDistance = 1
        ),
        pagingSourceFactory = {
            PhotoPagingSource(
                backend = repository
            )
        }
    ).flow
        .cachedIn(viewModelScope)
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
}
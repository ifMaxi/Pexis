package com.maxidev.pexis.ui.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.maxidev.pexis.data.remote.model.photo_search.Photo
import com.maxidev.pexis.data.repository.impl.PhotosRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class PhotosCuratedViewModel @Inject constructor(
    private val repository: PhotosRepositoryImpl
): ViewModel() {

    fun getImage(): Flow<PagingData<Photo>> {
        return repository.getCuratedPhotos(1, 1).cachedIn(viewModelScope)
    }
}
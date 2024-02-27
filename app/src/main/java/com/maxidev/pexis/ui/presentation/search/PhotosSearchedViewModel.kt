package com.maxidev.pexis.ui.presentation.search

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.maxidev.pexis.data.remote.model.photo_search.Photo
import com.maxidev.pexis.data.repository.impl.PhotosRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotosSearchedViewModel @Inject constructor(
    private val repository: PhotosRepositoryImpl
): ViewModel() {

    private val _search: MutableState<String> = mutableStateOf("")
    val search: State<String> = _search

    fun onSearchChange(newValue: String) {
        _search.value = newValue
    }

    private val _searchedImage = MutableStateFlow<PagingData<Photo>>(PagingData.empty())
    val searchedImage = _searchedImage

    fun getSearchedImages(query :String) {
        viewModelScope.launch {
            repository.getSearchedPhotos(
                query = query,
                perPage = 1,
                page = 1
            ).cachedIn(viewModelScope)
                .collect {
                    _searchedImage.value = it
                }
        }
    }
}
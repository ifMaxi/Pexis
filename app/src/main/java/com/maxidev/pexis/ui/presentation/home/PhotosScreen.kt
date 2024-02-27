package com.maxidev.pexis.ui.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.maxidev.pexis.R
import com.maxidev.pexis.data.remote.model.photo_search.Photo
import com.maxidev.pexis.ui.presentation.components.ListContent
import com.maxidev.pexis.ui.presentation.components.PexelsPhotoProviderComponent
import com.maxidev.pexis.ui.presentation.home.components.HomeTopBar

@Composable
fun PhotosScreen(
    viewModel: PhotosCuratedViewModel = hiltViewModel(),
) {
    val pagerPhoto: LazyPagingItems<Photo> = viewModel.getImage().collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                HomeTopBar(title = R.string.home)

                PexelsPhotoProviderComponent()
            }
        }
    ) { paddingValues ->
        ListContent(
            modifier = Modifier.padding(paddingValues),
            photos = pagerPhoto
        )
    }
}
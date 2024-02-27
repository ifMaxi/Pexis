package com.maxidev.pexis.ui.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import com.maxidev.pexis.R
import com.maxidev.pexis.data.remote.model.photo_search.Photo

@Composable
fun ListContent(
    modifier: Modifier = Modifier,
    photos: LazyPagingItems<Photo>
) {
    val state: LazyStaggeredGridState = rememberLazyStaggeredGridState()
    val photosRemember: LazyPagingItems<Photo> = remember { photos }

    if (photosRemember.loadState.refresh is LoadState.Loading) {
        PexisStatus(animation = R.raw.loading_image)
    }

    LazyVerticalStaggeredGrid(
        modifier = modifier
            .fillMaxSize(),
        columns = StaggeredGridCells.Fixed(2),
        state = state,
        contentPadding = PaddingValues(4.dp),
        verticalItemSpacing = 4.dp,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(
            count = photosRemember.itemCount,
            key = photosRemember.itemKey { it.id },
            contentType = photosRemember.itemContentType { it.id }
        ) { pexelImage ->
            photosRemember[pexelImage]?.let {
                ImageComponent(
                    image = it.src.original,
                    url = it.url,
                    photographer = it.photographer
                )
            }
        }
    }

    if (photosRemember.loadState.refresh is LoadState.Error) {
        PexisStatus(animation = R.raw.image_error)
    }
}
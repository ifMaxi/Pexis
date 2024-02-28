package com.maxidev.pexis.ui.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest

@Composable
fun CoilImage(
    modifier: Modifier = Modifier,
    image: String
) {
    val context = LocalContext.current
    val imageRequest = ImageRequest.Builder(context)
        .data(image)
        .crossfade(true)
        .memoryCachePolicy(CachePolicy.ENABLED)
        .diskCachePolicy(CachePolicy.ENABLED)
        .build()

    AsyncImage(
        model = imageRequest,
        contentDescription = null,
        modifier = modifier
    )
}
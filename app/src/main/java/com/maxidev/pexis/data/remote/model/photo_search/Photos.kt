package com.maxidev.pexis.data.remote.model.photo_search

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Photos(
    @SerialName("page")
    val page: Int,
    @SerialName("per_page")
    val perPage: Int,
    @SerialName("photos")
    val photos: List<Photo>,
    @SerialName("next_page")
    val nextPage: String
)
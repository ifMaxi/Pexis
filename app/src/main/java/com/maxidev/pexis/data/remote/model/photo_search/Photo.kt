package com.maxidev.pexis.data.remote.model.photo_search

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Photo(
    @SerialName("id")
    val id: Int,
    @SerialName("width")
    val width: Int,
    @SerialName("height")
    val height: Int,
    @SerialName("url")
    val url: String,
    @SerialName("photographer")
    val photographer: String,
    @SerialName("photographer_url")
    val photographerUrl: String,
    @SerialName("photographer_id")
    val photographerId: Int,
    @SerialName("avg_color")
    val avgColor: String,
    @SerialName("src")
    val src: Src,
    @SerialName("liked")
    val liked: Boolean,
    @SerialName("alt")
    val alt: String
)
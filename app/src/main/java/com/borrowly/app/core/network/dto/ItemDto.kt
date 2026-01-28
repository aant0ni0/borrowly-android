package com.borrowly.app.core.network.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ItemDto(
    val id: String,
    val name: String,
    val description: String,
    val state: String,
    val ownerId: String
)

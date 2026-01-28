package com.borrowly.app.core.network.dto

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class UserDto(
    val id: String,
    val name: String,
    val reputation: Int
)

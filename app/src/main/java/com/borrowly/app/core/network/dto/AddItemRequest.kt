package com.borrowly.app.core.network.dto

data class AddItemRequest(
    val name: String,
    val description: String,
    val ownerId: String
)

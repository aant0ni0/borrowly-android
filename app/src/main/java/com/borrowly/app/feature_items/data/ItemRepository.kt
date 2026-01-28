package com.borrowly.app.feature_items.data

import com.borrowly.app.core.network.dto.ItemDto

interface ItemRepository {
    suspend fun getItems(): List<ItemDto>
    suspend fun getItemById(id: String): ItemDto
    suspend fun addItem(name: String, description: String, ownerId: String)
    suspend fun reserveItem(id: String)
    suspend fun returnItem(id: String)
}

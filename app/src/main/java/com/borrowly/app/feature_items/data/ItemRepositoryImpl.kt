package com.borrowly.app.feature_items.data

import com.borrowly.app.core.network.ApiClient
import com.borrowly.app.core.network.dto.AddItemRequest
import com.borrowly.app.core.network.dto.ItemDto

class ItemRepositoryImpl : ItemRepository {

    private val api = ApiClient.api

    override suspend fun getItems(): List<ItemDto> = api.getItems()

    override suspend fun getItemById(id: String): ItemDto = api.getItemById(id)

    override suspend fun addItem(name: String, description: String, ownerId: String) {
        api.addItem(AddItemRequest(name = name, description = description, ownerId = ownerId))
    }

    override suspend fun reserveItem(id: String) {
        api.reserveItem(id)
    }

    override suspend fun returnItem(id: String) {
        api.returnItem(id)
    }
}

package com.borrowly.app.feature_items

import com.borrowly.app.core.network.dto.ItemDto

data class ItemUiState(
    val items: List<ItemDto> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

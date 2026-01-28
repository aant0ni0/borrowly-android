package com.borrowly.app.feature_items

import ItemViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ItemDetailsScreen(
    itemId: String,
    onBack: () -> Unit
) {
    val viewModel = remember { ItemViewModel() }
    val state by viewModel.uiState.collectAsState()

    val item = state.items.find { it.id == itemId }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Button(onClick = onBack) {
            Text("Back")
        }

        Spacer(Modifier.height(16.dp))

        if (item == null) {
            Text("Item not found")
            return
        }

        Text(
            text = item.name,
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(Modifier.height(8.dp))

        Text(text = item.description)

        Spacer(Modifier.height(8.dp))

        Text(text = "Status: ${item.state}")

        Spacer(Modifier.height(24.dp))

        if (item.state == "AVAILABLE") {
            Button(
                onClick = {
                    viewModel.reserveItem(item.id)
                    onBack()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Borrow")
            }
        } else {
            Button(
                onClick = {
                    viewModel.returnItem(item.id)
                    onBack()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Return")
            }
        }
    }
}

package com.borrowly.app.feature_items

import ItemViewModel
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ItemListScreen(
    onItemClick: (String) -> Unit,
    onUsersClick: () -> Unit
) {
    val viewModel = remember { ItemViewModel() }
    val state by viewModel.uiState.collectAsState()
    var showDialog by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Items",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(Modifier.height(16.dp))

            if (state.isLoading) {
                CircularProgressIndicator()
            }

            state.error?.let {
                Text(
                    text = it,
                    color = MaterialTheme.colorScheme.error
                )
            }

            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {
                items(state.items) { item ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .clickable {
                                onItemClick(item.id)
                            }
                    ) {
                        Column(
                            modifier = Modifier.padding(12.dp)
                        ) {
                            Text(
                                text = item.name,
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text(
                                text = item.description,
                                style = MaterialTheme.typography.bodyMedium
                            )
                            Text(
                                text = "Status: ${item.state}",
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                }
            }

            Spacer(Modifier.height(8.dp))

            Button(
                onClick = onUsersClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Go to users")
            }
        }

        FloatingActionButton(
            onClick = { showDialog = true },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Text("+")
        }

        if (showDialog) {
            AddItemDialog(
                onDismiss = { showDialog = false },
                onAdd = { name, description ->
                    viewModel.addItem(name, description)
                }
            )
        }
    }
}

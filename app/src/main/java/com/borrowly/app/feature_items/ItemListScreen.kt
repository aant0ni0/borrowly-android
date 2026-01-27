package com.borrowly.app.feature_items

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ItemlistScreen(
    onItemClick: (String) -> Unit,
    onUsersClick: () -> Unit
){
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = "Items",
            style = MaterialTheme.typography.headlineMedium,
        )
        Spacer(Modifier.height(16.dp))

        Button(onClick = {onItemClick("i1")}) {
            Text("Go to item details")
        }

        Spacer(Modifier.height(16.dp))

        Button(onClick = {onUsersClick()}) {
            Text("Go to users")
        }
    }
}
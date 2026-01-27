package com.borrowly.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.navigation.compose.rememberNavController
import com.borrowly.app.core.ui.theme.BorrowlyTheme
import com.borrowly.app.navigation.BorrowlyNavGraph

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BorrowlyTheme {
                val navController = rememberNavController()
                BorrowlyNavGraph(navController)
            }
        }
    }
}

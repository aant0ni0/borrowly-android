package com.borrowly.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.borrowly.app.feature_items.ItemlistScreen
import com.borrowly.app.feature_items.ItemDetailsScreen
import com.borrowly.app.feature_users.UserListScreen

@Composable
fun BorrowlyNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Routes.ITEMS
    ) {

        composable(Routes.ITEMS) {
            ItemlistScreen(
                onItemClick = { itemId: String ->
                    navController.navigate("${Routes.ITEM_DETAILS}/$itemId")
                },
                onUsersClick = {
                    navController.navigate(Routes.USERS)
                }
            )
        }

        composable("${Routes.ITEM_DETAILS}/{itemId}") {
            ItemDetailsScreen()
        }

        composable(Routes.USERS) {
            UserListScreen()
        }
    }
}



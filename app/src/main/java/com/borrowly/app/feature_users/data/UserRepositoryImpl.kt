package com.borrowly.app.feature_users.data

import com.borrowly.app.core.network.ApiClient
import com.borrowly.app.core.network.dto.UserDto

class UserRepositoryImpl : UserRepository {

    private val api = ApiClient.api

    override suspend fun getUsers(): List<UserDto> = api.getUsers()

    override suspend fun getUserById(id: String): UserDto = api.getUserById(id)
}

package com.borrowly.app.feature_users.data

import com.borrowly.app.core.network.dto.UserDto

interface UserRepository {
    suspend fun getUsers(): List<UserDto>
    suspend fun getUserById(id: String): UserDto
}

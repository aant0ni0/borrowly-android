package com.borrowly.app.core.network

import com.borrowly.app.core.network.dto.*
import retrofit2.http.*

interface ApiService {

    @GET("items")
    suspend fun getItems(): List<ItemDto>

    @POST("items")
    suspend fun addItem(@Body body: AddItemRequest): ItemDto

    @GET("items/{id}")
    suspend fun getItemById(@Path("id") id: String): ItemDto

    @PUT("items/{id}/reserve")
    suspend fun reserveItem(@Path("id") id: String)

    @PUT("items/{id}/return")
    suspend fun returnItem(@Path("id") id: String)

    @GET("users")
    suspend fun getUsers(): List<UserDto>

    @GET("users/{id}")
    suspend fun getUserById(@Path("id") id: String): UserDto
}

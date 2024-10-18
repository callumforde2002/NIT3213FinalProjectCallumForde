package com.example.nit3213finalproject

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

// Data class for login request payload
data class LoginRequest(
    val username: String,
    val password: String
)

// Data class for login response payload
data class LoginResponse(
    val keypass: String
)

// Retrofit interface defining API endpoints
interface ApiService {

    @POST("/footscray/auth") // Replace this with the correct endpoint based on your class location
    fun login(
        @Body request: LoginRequest
    ): Call<LoginResponse>
}

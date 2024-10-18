package com.example.nit3213finalproject

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import java.io.Serializable

// Data class for login request payload
data class LoginRequest(
    val username: String,
    val password: String
)

// Data class for login response payload
data class LoginResponse(
    val keypass: String
)

// Data class for dashboard response payload
data class DashboardResponse(
    val entities: List<Entity>,  // List of entities returned from the dashboard API
    val entityTotal: Int         // Total number of entities
)

// Data class for individual entity, made serializable to be passed between activities
data class Entity(
    val property1: String,
    val property2: String,
    val description: String
) : Serializable  // This makes the Entity class serializable

// Retrofit interface defining API endpoints
interface ApiService {

    @POST("/footscray/auth") // Replace with the correct endpoint based on your class location
    fun login(
        @Body request: LoginRequest
    ): Call<LoginResponse>

    @GET("/dashboard/{keypass}") // Dashboard endpoint
    fun getDashboard(
        @Path("keypass") keypass: String
    ): Call<DashboardResponse>
}

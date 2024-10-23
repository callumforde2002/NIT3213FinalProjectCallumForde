package com.example.nit3213finalproject

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

// Data class for login request payload
data class LoginRequest(
    val username: String,  // YourFirstName
    val password: String   // Format: sYourStudentID
)

// Data class for login response payload
data class LoginResponse(
    val keypass: String    // Topic name returned upon successful login
)

// Data class for dashboard response payload
data class DashboardResponse(
    val entities: List<Entity>,  // List of entities returned from the dashboard API
    val entityTotal: Int         // Total number of entities
)

// Retrofit interface defining API endpoints
interface ApiService {

    @POST("/footscray/auth") // Replace with "/sydney/auth" or "/ort/auth" based on class location
    fun login(
        @Body request: LoginRequest
    ): Call<LoginResponse>

    @GET("/dashboard/{keypass}") // Dashboard endpoint
    fun getDashboard(
        @Path("keypass") keypass: String
    ): Call<DashboardResponse>
}

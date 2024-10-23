package com.example.nit3213finalproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class DashboardActivity : ComponentActivity() {

    @Inject
    lateinit var apiService: ApiService

    private lateinit var recyclerView: RecyclerView
    private lateinit var entityAdapter: EntityAdapter
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard) // Ensure this matches your XML layout file

        // Initialize views
        recyclerView = findViewById(R.id.recyclerViewEntities) // Ensure ID matches XML
        progressBar = findViewById(R.id.progressBar)           // Ensure ID matches XML

        // Set up RecyclerView with a LinearLayoutManager
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize adapter with an empty list
        entityAdapter = EntityAdapter(emptyList()) { entity ->
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("entity", entity)
            startActivity(intent)
        }
        recyclerView.adapter = entityAdapter

        // Retrieve the keypass from the intent
        val keypass = intent.getStringExtra("keypass")
        if (keypass != null) {
            Log.d("DashboardActivity", "Received keypass: $keypass")
            fetchDashboardData(keypass)
        } else {
            Log.e("DashboardActivity", "Keypass is missing")
            Toast.makeText(this, "Keypass is missing", Toast.LENGTH_SHORT).show()
        }
    }

    private fun fetchDashboardData(keypass: String) {
        Log.d("DashboardActivity", "Fetching dashboard data with keypass: $keypass")

        // Show progress bar while data is being fetched
        progressBar.visibility = View.VISIBLE

        apiService.getDashboard(keypass).enqueue(object : Callback<DashboardResponse> {
            override fun onResponse(call: Call<DashboardResponse>, response: Response<DashboardResponse>) {
                progressBar.visibility = View.GONE

                if (response.isSuccessful) {
                    val entities = response.body()?.entities ?: emptyList()
                    Log.d("DashboardActivity", "Received ${entities.size} entities")
                    // Update adapter with the fetched entities
                    entityAdapter.updateData(entities)
                    if (entities.isEmpty()) {
                        Toast.makeText(this@DashboardActivity, "No entities available", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Log.e("DashboardActivity", "Failed to load dashboard data: ${response.code()}")
                    Toast.makeText(this@DashboardActivity, "Failed to load dashboard data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<DashboardResponse>, t: Throwable) {
                progressBar.visibility = View.GONE
                Log.e("DashboardActivity", "Error fetching dashboard data: ${t.message}")
                Toast.makeText(this@DashboardActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}

package com.example.nit3213finalproject

import android.os.Bundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        recyclerView = findViewById(R.id.recyclerViewEntities)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Get the keypass from the intent
        val keypass = intent.getStringExtra("keypass")
        if (keypass != null) {
            fetchDashboardData(keypass)
        } else {
            Toast.makeText(this, "Keypass is missing", Toast.LENGTH_SHORT).show()
        }
    }

    private fun fetchDashboardData(keypass: String) {
        apiService.getDashboard(keypass).enqueue(object : Callback<DashboardResponse> {
            override fun onResponse(call: Call<DashboardResponse>, response: Response<DashboardResponse>) {
                if (response.isSuccessful) {
                    val entities = response.body()?.entities ?: emptyList()
                    setupRecyclerView(entities)
                } else {
                    Toast.makeText(this@DashboardActivity, "Failed to load dashboard data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<DashboardResponse>, t: Throwable) {
                Toast.makeText(this@DashboardActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setupRecyclerView(entities: List<Entity>) {
        entityAdapter = EntityAdapter(entities) { entity ->
            // Handle click event, navigate to DetailsActivity
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("entity", entity)
            startActivity(intent)
        }
        recyclerView.adapter = entityAdapter
    }
}

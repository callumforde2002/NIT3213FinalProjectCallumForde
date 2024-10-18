package com.example.nit3213finalproject

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // Get the keypass from the Intent
        val keypass = intent.getStringExtra("keypass")

        // Set the keypass to the TextView
        val keypassTextView = findViewById<TextView>(R.id.tvKeypass)
        keypassTextView.text = keypass
    }
}

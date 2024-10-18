package com.example.nit3213finalproject

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        // Get the entity from the intent
        val entity = intent.getSerializableExtra("entity") as? Entity

        // If entity is not null, populate the details
        if (entity != null) {
            val property1TextView = findViewById<TextView>(R.id.tvProperty1Detail)
            val property2TextView = findViewById<TextView>(R.id.tvProperty2Detail)
            val descriptionTextView = findViewById<TextView>(R.id.tvDescriptionDetail)

            property1TextView.text = entity.property1
            property2TextView.text = entity.property2
            descriptionTextView.text = entity.description
        }
    }
}

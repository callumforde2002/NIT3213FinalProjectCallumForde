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

        val entity = intent.getSerializableExtra("entity") as? Entity

        if (entity != null) {
            val nameTextView = findViewById<TextView>(R.id.tvNameDetail)
            val cultureTextView = findViewById<TextView>(R.id.tvCultureDetail)
            val domainTextView = findViewById<TextView>(R.id.tvDomainDetail)
            val symbolTextView = findViewById<TextView>(R.id.tvSymbolDetail)
            val parentageTextView = findViewById<TextView>(R.id.tvParentageDetail)
            val romanEquivalentTextView = findViewById<TextView>(R.id.tvRomanEquivalentDetail)
            val descriptionTextView = findViewById<TextView>(R.id.tvDescriptionDetail)

            // Update the TextViews with the entity's data
            nameTextView.text = entity.name
            cultureTextView.text = entity.culture
            domainTextView.text = entity.domain
            symbolTextView.text = entity.symbol
            parentageTextView.text = entity.parentage
            romanEquivalentTextView.text = entity.romanEquivalent
            descriptionTextView.text = entity.description
        }
    }
}

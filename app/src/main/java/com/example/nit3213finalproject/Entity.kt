package com.example.nit3213finalproject

import java.io.Serializable

// Data class for individual entity, made serializable to be passed between activities
data class Entity(
    val name: String,
    val culture: String,
    val domain: String,
    val symbol: String,
    val parentage: String,
    val romanEquivalent: String,
    val description: String
) : Serializable  // This makes the Entity class serializable

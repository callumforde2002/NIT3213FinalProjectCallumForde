package com.example.nit3213finalproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EntityAdapter(
    private var entities: List<Entity>, // Change to var to allow updating the list
    private val onItemClick: (Entity) -> Unit
) : RecyclerView.Adapter<EntityAdapter.EntityViewHolder>() {

    // ViewHolder class for the items in the RecyclerView
    inner class EntityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.tvName)
        private val cultureTextView: TextView = itemView.findViewById(R.id.tvCulture)
        private val domainTextView: TextView = itemView.findViewById(R.id.tvDomain)

        fun bind(entity: Entity) {
            nameTextView.text = entity.name
            cultureTextView.text = entity.culture
            domainTextView.text = entity.domain

            // Set click listener for each item
            itemView.setOnClickListener {
                onItemClick(entity)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntityViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_entity, parent, false)
        return EntityViewHolder(view)
    }

    override fun onBindViewHolder(holder: EntityViewHolder, position: Int) {
        holder.bind(entities[position])
    }

    override fun getItemCount(): Int = entities.size

    // Method to update the list of entities and refresh the RecyclerView
    fun updateData(newEntities: List<Entity>) {
        entities = newEntities
        notifyDataSetChanged() // Notify the adapter that the dataset has changed
    }
}

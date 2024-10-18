package com.example.nit3213finalproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EntityAdapter(
    private val entities: List<Entity>,
    private val onItemClick: (Entity) -> Unit
) : RecyclerView.Adapter<EntityAdapter.EntityViewHolder>() {

    inner class EntityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val property1TextView: TextView = itemView.findViewById(R.id.tvProperty1)
        val property2TextView: TextView = itemView.findViewById(R.id.tvProperty2)

        fun bind(entity: Entity) {
            property1TextView.text = entity.property1
            property2TextView.text = entity.property2
            itemView.setOnClickListener {
                onItemClick(entity) // Trigger click event for the entity
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
}

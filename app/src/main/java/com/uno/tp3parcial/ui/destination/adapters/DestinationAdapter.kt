package com.uno.tp3parcial.ui.destination.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uno.tp3parcial.R
import com.uno.tp3parcial.ui.destination.entities.Destination
import com.uno.tp3parcial.ui.destination.holders.DestinationViewHolder

class DestinationAdapter(private val items: List<Destination>) : RecyclerView.Adapter<DestinationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DestinationViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_destination, parent, false)
        return DestinationViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DestinationViewHolder, position: Int) {
        val currentItem = items[position]
        holder.tvTitle.text = currentItem.titulo
        holder.tvDescription.text = currentItem.descripcion
        holder.ivImage.setImageResource(currentItem.imagen)
    }

    override fun getItemCount() = items.size
}




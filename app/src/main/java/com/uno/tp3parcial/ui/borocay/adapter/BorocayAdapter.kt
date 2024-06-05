package com.uno.tp3parcial.ui.search_results.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uno.tp3parcial.R
import com.uno.tp3parcial.ui.search_results.holder.BorocayViewHolder
import com.uno.tp3parcial.ui.search_results.entities.PhotosBorocay

class BorocayAdapter(private val items: List<PhotosBorocay>) : RecyclerView.Adapter<BorocayViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BorocayViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
        return BorocayViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BorocayViewHolder, position: Int) {
        val currentItem = items[position]
        holder.ivImage.setImageResource(currentItem.imagen)
    }

    override fun getItemCount() = items.size
}

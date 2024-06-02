package com.uno.tp3parcial.ui.offers.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uno.tp3parcial.R
import com.uno.tp3parcial.ui.offers.entities.Offer
import com.uno.tp3parcial.ui.offers.holders.OffersViewHolder

class OffersAdapter(private val items: List<Offer>) : RecyclerView.Adapter<OffersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OffersViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_offer, parent, false)
        return OffersViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: OffersViewHolder, position: Int) {
        val currentItem = items[position]
        holder.tvTitle.text = currentItem.titulo
        holder.tvDescription.text = currentItem.descripcion
    }

    override fun getItemCount() = items.size


}

data class Offer(val title: String, val description: String)



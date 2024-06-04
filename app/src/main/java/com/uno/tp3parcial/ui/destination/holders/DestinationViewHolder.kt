package com.uno.tp3parcial.ui.destination.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uno.tp3parcial.R

class DestinationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
    val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
    val ivImage: ImageView = itemView.findViewById(R.id.card_image_offer_item)
    val destinationID: TextView = itemView.findViewById(R.id.destinationID)
}
package com.uno.tp3parcial.ui.search_results.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uno.tp3parcial.R
import com.uno.tp3parcial.ui.search_results.entities.Search_results_entities
import com.uno.tp3parcial.ui.search_results.holder.SearchResultsViewHolder

class SearchResultAdapter(private val items: List<Search_results_entities>) : RecyclerView.Adapter<SearchResultsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_vuelo_searchr, parent, false)
        return SearchResultsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SearchResultsViewHolder, position: Int) {
        val currentItem = items[position]
        holder.ivImage.setImageResource(currentItem.imagen)
    }

    override fun getItemCount() = items.size
}

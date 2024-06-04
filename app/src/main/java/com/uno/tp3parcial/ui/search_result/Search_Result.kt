package com.uno.tp3parcial.ui.search_result

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uno.tp3parcial.R
import com.uno.tp3parcial.ui.search_results.adapter.SearchResultAdapter
import com.uno.tp3parcial.ui.search_results.entities.Search_results_entities

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Search_Result : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchRAdapter: SearchResultAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.search_result, container, false)

        // Initialize the RecyclerView
        recyclerView =
            view.findViewById(R.id.recViewSearchR) // Make sure the ID matches your layout
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)


        val filipinas1: Int = R.drawable.filipinas1
        val filipinas2: Int = R.drawable.filipinas2
        val filipinas3: Int = R.drawable.filipinas3


        val imagen = listOf(
            Search_results_entities(filipinas1),
            Search_results_entities(filipinas2),
            Search_results_entities(filipinas3)
        )

        // Initialize the adapter
        searchRAdapter = SearchResultAdapter(imagen) // Pass an empty list or your data here

        // Set the adapter to the RecyclerView
        recyclerView.adapter = searchRAdapter

        val view2 = inflater.inflate(R.layout.item_vuelo_searchr, container, false)

        val searchButton = view2.findViewById<Button>(R.id.view_details_btn)

        searchButton.setOnClickListener {
            findNavController().navigate(R.id.action_search_to_borocay)
        }
        val backButton = view.findViewById<ImageButton>(R.id.back_button)
        backButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        // return inflater.inflate(R.layout.search_result, container, false)
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = Search_Result()
    }
}

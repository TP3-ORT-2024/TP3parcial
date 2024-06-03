package com.uno.tp3parcial.ui.explore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uno.tp3parcial.R
import com.uno.tp3parcial.R.*
import com.uno.tp3parcial.ui.destination.adapters.DestinationAdapter
import com.uno.tp3parcial.ui.destination.entities.Destination

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Explore : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var recyclerView: RecyclerView
    private lateinit var destinationAdapter: DestinationAdapter

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
        val view = inflater.inflate(layout.explore, container, false)

        // Initialize the RecyclerView
        recyclerView = view.findViewById(R.id.recViewOffers) // Make sure the ID matches your layout
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)




        val imageBoracay: Int = R.drawable.boracay
        val imageBaros: Int = R.drawable.baros
        val imageBali: Int = R.drawable.bali
        val imagePalawan: Int = R.drawable.palawan

        val locationOne = getString(R.string.locationOne)
        val locationTwo = getString(R.string.locationTwo)
        val locationThree = getString(R.string.locationThree)
        val locationFour = getString(R.string.locationFour)

        val countryOne = getString(R.string.countryOne)
        val countryTwo = getString(R.string.countryTwo)
        val countryThree = getString(R.string.countryThree)
        val countryFour = getString(R.string.countryFour)

        val destinations = listOf(
            Destination(locationOne, countryOne,imageBoracay),
            Destination(locationTwo, countryTwo,imageBaros),
            Destination(locationThree, countryThree,imageBali),
            Destination(locationFour, countryFour,imagePalawan),
        )

        destinationAdapter = DestinationAdapter(destinations)
        recyclerView.adapter = destinationAdapter

        return view
    }



    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Explore().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


}
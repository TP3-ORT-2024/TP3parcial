package com.uno.tp3parcial.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputLayout
import com.uno.tp3parcial.R
import com.uno.tp3parcial.R.*
import com.uno.tp3parcial.ui.offers.adapters.OffersAdapter
import com.uno.tp3parcial.ui.offers.entities.Offer

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Search : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var recyclerView: RecyclerView
    private lateinit var offerAdapter: OffersAdapter

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
        val view = inflater.inflate(layout.searchc, container, false)

        // Initialize the RecyclerView
        recyclerView = view.findViewById(R.id.recViewOffers) // Make sure the ID matches your layout
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)


        val titleMastercard = getString(R.string.offers_rv_tiitulo_mastecard)
        val titleVisa = getString(R.string.offers_rv_tiitulo_visa)
        val limitedOffer = getString(R.string.offers_rv_limited)

        val ofertas = listOf(
            Offer(titleMastercard, limitedOffer),
            Offer(titleVisa, limitedOffer)
        )

        // Initialize the adapter
        offerAdapter = OffersAdapter(ofertas) // Pass an empty list or your data here

        // Set the adapter to the RecyclerView
        recyclerView.adapter = offerAdapter

        val toggleGroup = view.findViewById<RadioGroup>(R.id.toggleGroup)
        val oneWayButton = view.findViewById<RadioButton>(R.id.oneWay)
        val roundTripButton = view.findViewById<RadioButton>(R.id.roundTrip)

        toggleGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.oneWay -> {
                    // Handle one way selected
                }
                R.id.roundTrip -> {
                    // Handle round trip selected
                }
            }
        }

        // Set initial state if needed
        oneWayButton.isChecked = true

        val inputDate = view.findViewById<EditText>(R.id.input_date)
        inputDate.setOnClickListener {
            showDatePickerDialog()
        }
        return view
    }

    private fun showDatePickerDialog() {
        val builder = MaterialDatePicker.Builder.datePicker()
        builder.setTitleText("Select Date")
        val datePicker = builder.build()

        datePicker.addOnPositiveButtonClickListener { selection ->
            // Update the EditText with the selected date
            val editText = view?.findViewById<EditText>(R.id.input_date)
            editText?.setText(datePicker.getHeaderText())
        }

        datePicker.show(parentFragmentManager, "DATE_PICKER")
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Search().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


}
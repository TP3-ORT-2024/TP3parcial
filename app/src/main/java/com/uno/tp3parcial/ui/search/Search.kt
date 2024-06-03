package com.uno.tp3parcial.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputLayout
import com.uno.tp3parcial.R
import com.uno.tp3parcial.R.*
import com.uno.tp3parcial.ui.offers.adapters.OffersAdapter
import com.uno.tp3parcial.ui.offers.entities.Offer
import com.uno.tp3parcial.ui.search_result.Search_Result

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
        val view = inflater.inflate(layout.searchc, container, false)

        recyclerView = view.findViewById(R.id.recViewOffers)
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)


        val titleMastercard = getString(R.string.offers_rv_tiitulo_mastecard)
        val titleVisa = getString(R.string.offers_rv_tiitulo_visa)
        val limitedOffer = getString(R.string.offers_rv_limited)
        val imageMastercard: Int = R.drawable.ic_mastercard
        val imageVisa: Int = R.drawable.ic_visa


        val ofertas = listOf(
            Offer(titleMastercard, limitedOffer, imageMastercard),
            Offer(titleVisa, limitedOffer, imageVisa)
        )

        offerAdapter = OffersAdapter(ofertas)

        recyclerView.adapter = offerAdapter


        val inputDate = view.findViewById<EditText>(R.id.input_date)
        inputDate.setOnClickListener {
            showDatePickerDialog()
        }

        val backButton = view.findViewById<ImageButton>(R.id.back_button)
        backButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        val searchButton = view.findViewById<Button>(R.id.search_button)
        searchButton.setOnClickListener {
            findNavController().navigate(R.id.action_searchFragment_to_searchResultFragment)
        }


        return view
    }

    private fun showDatePickerDialog() {
        val builder = MaterialDatePicker.Builder.datePicker()
        builder.setTitleText("Select Date")
        val datePicker = builder.build()

        datePicker.addOnPositiveButtonClickListener { selection ->
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
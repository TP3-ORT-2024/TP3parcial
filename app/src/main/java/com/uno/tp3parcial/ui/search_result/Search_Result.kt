package com.uno.tp3parcial.ui.search_result

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.uno.tp3parcial.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Search_Result : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

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
        return inflater.inflate(R.layout.search_result, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = Search_Result()
    }
}

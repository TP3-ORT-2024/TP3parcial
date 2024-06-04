package com.uno.tp3parcial.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.ImageButton

import android.widget.Button

import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController

import com.uno.tp3parcial.R
import com.uno.tp3parcial.R.id.settings

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Profile : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.profile, container, false)


        val backButton = view.findViewById<ImageButton>(R.id.back_button)
        backButton.setOnClickListener {
            parentFragmentManager.popBackStack()


        // Obtener NavController
       // navController = findNavController()

        // Manejador de clic del icono de configuración

        //val settingsButton = view.findViewById<ImageButton>(R.id.settingsButton)

        //settingsButton.setOnClickListener {
          //  navController.navigate(R.id.action_profile_to_settings)
         
        //}

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Profile().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


}
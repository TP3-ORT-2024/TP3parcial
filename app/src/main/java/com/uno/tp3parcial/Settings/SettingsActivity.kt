package com.uno.tp3parcial.Settings

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.uno.tp3parcial.R

class SettingsActivity : AppCompatActivity() {
    companion object {
        const val KEY_DARK_MODE = "key_dark_mode"
    }

    private var firstTime:Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}
package com.uno.tp3parcial.todoapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.uno.tp3parcial.R
import com.uno.tp3parcial.SettingsActivity

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.profile)
        val btnSettings = findViewById<Button>(R.id.btnSettings)

        btnSettings.setOnClickListener { navigateToSettings() }
        }

    private fun navigateToSettings() {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }
    }
}
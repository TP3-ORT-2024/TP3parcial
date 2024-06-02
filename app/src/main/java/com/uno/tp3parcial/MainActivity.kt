package com.uno.tp3parcial
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.preference.Preference
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val settingsButton = findViewById<Button>(R.id.settingsButton)
        settingsButton.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)  // Create an intent to launch SettingsActivity
            startActivity(intent)  // Start the SettingsActivity
                
        }
    }
}


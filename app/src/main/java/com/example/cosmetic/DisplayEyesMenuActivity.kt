package com.example.cosmetic

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class DisplayEyesMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_eyemenu)
        findViewById<ImageView>(R.id.imageViewEyeMenu1).setOnClickListener {
            showEyesMenu1Detail()
        }
    }

    private fun showEyesMenu1Detail() {
        setContentView(R.layout.activity_display_eyedetail)
    }
}
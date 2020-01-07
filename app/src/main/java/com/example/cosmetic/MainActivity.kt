package com.example.cosmetic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 = findViewById<ImageView>(R.id.imageViewLip)
        val button2 = findViewById<ImageView>(R.id.imageViewEyes)
        val button3 = findViewById<ImageView>(R.id.imageViewFoundation)
        button1.setOnClickListener {
            Toast.makeText(this, "Lip selected", Toast.LENGTH_SHORT).show()
            onClick(button1) }
        button2.setOnClickListener {
            Toast.makeText(this, "Eyes selected", Toast.LENGTH_SHORT).show()
            onClick(button2) }
        button3.setOnClickListener {
            Toast.makeText(this, "Foundation selected", Toast.LENGTH_SHORT).show()
            onClick(button3) }

    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.imageViewEyes -> {
                val intent = Intent(this, DisplayEyesMenuActivity::class.java)
                startActivity(intent)
            }
            R.id.imageViewLip -> {
                val intent = Intent(this, DisplayLipMenuActivity::class.java)
                startActivity(intent)
            }else -> {
                val intent = Intent(this, DisplayFoundationMenuActivity::class.java)
            startActivity(intent)
        }

        }
    }

}

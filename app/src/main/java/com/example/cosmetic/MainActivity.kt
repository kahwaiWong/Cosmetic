package com.example.cosmetic

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity(), myRef.addValueEventListener(object: ValueEventListener {

    override fun onDataChange(dataSnapshot: DataSnapshot) {
        // This method is called once with the initial value and again
        // whenever data at this location is updated.
        val value = dataSnapshot.getValue(String::class.java)
        Log.d(TAG, "Value is: $value")
    }

    override fun onCancelled(error: DatabaseError) {
        // Failed to read value
        Log.w(TAG, "Failed to read value.", error.toException())
    }
}), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("cosmetic")


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


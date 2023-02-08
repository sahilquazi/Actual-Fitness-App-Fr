package com.example.exerme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //sahil page


val secondActButton = findViewById<Button>(R.id.rahButton)
        secondActButton.setOnClickListener {
            val Intent = Intent(this, quizpagesahil::class.java)
       startActivity(Intent)
        }
   




        //alex page




        //nguyen page

    }
}
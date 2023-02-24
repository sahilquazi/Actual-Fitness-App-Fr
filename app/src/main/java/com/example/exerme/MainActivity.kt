package com.example.exerme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameQuiz = findViewById<TextView>(R.id.edtTextName)
        val emailQuiz = findViewById<TextView>(R.id.edtTextEmail)
        val buttonQuiz = findViewById<Button>(R.id.SignUpButton)
        val intent = Intent(this, DashboardActivity::class.java)

        val preferences = getSharedPreferences("PREFERENCES", 0)

        val nameData = preferences.getString("nameQuiz", null)
        if (nameData != null) {
            startActivity(intent)
            finish()
        }

        buttonQuiz.setOnClickListener {
            val name = nameQuiz.text.toString()
            val email = emailQuiz.text.toString()

            val editor = preferences.edit()
            editor.putString("nameQuiz", name)
            editor.putString("emailQuiz", email)
            editor.apply()

            startActivity(intent)
            finish()
        }
    }
}
package com.example.exerme

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuizPageActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
            super.onCreate(savedInstanceState, persistentState)
            setContentView(R.layout.quizpage)

            val nameQuiz = findViewById<TextView>(R.id.editTextTextPersonName2)
            val emailQuiz = findViewById<TextView>(R.id.editTextTextEmailAddress2)
            val buttonQuiz = findViewById<Button>(R.id.button2)

            val preferences = getSharedPreferences("PREFERENCES", 0)

            buttonQuiz.setOnClickListener {
                val name = nameQuiz.text.toString()
                val email = emailQuiz.text.toString()

                val editor = preferences.edit()
                editor.putString("nameQuiz", name)
                editor.putString("emailQuiz", email)
                editor.apply()
            }

            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
            finish()
        }
}
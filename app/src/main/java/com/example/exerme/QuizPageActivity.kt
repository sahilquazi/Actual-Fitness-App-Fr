package com.example.exerme

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit

class QuizPageActivity : AppCompatActivity() {

        private var pref: SharedPreferences = getSharedPreferences("mypref", MODE_PRIVATE)

        override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
            super.onCreate(savedInstanceState, persistentState)
            setContentView(R.layout.quizpage)
            if (pref.getBoolean("firstTime", true)) { // use default of true
                pref.edit { putBoolean("firstTime", false) } // persist value of false
                // show T&C dialog that calls goToMain() when accepted
            } else {
                goToMain()
            }
        }

        private fun goToMain() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // close this activity since we don't want it in back stack
        }
    }
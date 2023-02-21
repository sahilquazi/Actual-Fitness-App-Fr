package com.example.exerme

import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        var prefs = PreferenceManager
            .getDefaultSharedPreferences(this)
        if (!prefs.getBoolean("firstTime", false)) {
            val editor = prefs.edit()
            editor.putBoolean("firstTime", true)
            editor.commit()
        }
        if (prefs == true) {
            setContentView(R.layout.quizpage)
        }

            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_dashboard)

        val dashboardToolbar = null
        setSupportActionBar(dashboardToolbar)

            val buttonClick = findViewById<Button>(R.id.rahButton)
            buttonClick.setOnClickListener {
                setContentView(R.layout.quizpage)
            }

            val buttonClick2 = findViewById<Button>(R.id.calendarButton)
            buttonClick2.setOnClickListener {
                setContentView(R.layout.activity_calendar)
            }


        }
    }

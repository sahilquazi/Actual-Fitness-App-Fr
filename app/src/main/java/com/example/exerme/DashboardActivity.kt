package com.example.exerme

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val buttonClick2 = findViewById<Button>(R.id.calendarButton)
        buttonClick2.setOnClickListener {
            setContentView(R.layout.activity_calendar)
        }

        val buttonClick = findViewById<Button>(R.id.rahButton)
        buttonClick.setOnClickListener {
            setContentView(R.layout.quizpage)
        }

    }
}
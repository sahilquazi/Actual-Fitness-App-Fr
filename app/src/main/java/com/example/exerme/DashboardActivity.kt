package com.example.exerme

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_dashboard)

            val buttonCalendar = findViewById<Button>(R.id.calendarButton)
            buttonCalendar.setOnClickListener {
                val intent = Intent(this, CalendarActivity::class.java)
                startActivity(intent)
            }


        }
    }

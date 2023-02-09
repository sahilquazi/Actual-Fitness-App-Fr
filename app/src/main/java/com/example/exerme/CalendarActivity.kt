package com.example.exerme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import android.widget.TextView

class CalendarActivity : AppCompatActivity() {
    var calendarView = findViewById<CalendarView>(R.id.calendarView)
    var textView = findViewById<TextView>(R.id.textView2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val today = (dayOfMonth.toString() + "-" + (month + 1) + "-" + year)
            textView.text = today

        }
    }
}
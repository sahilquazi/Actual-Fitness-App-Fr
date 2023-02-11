package com.example.exerme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import java.util.*

class CalendarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        val calendar = Calendar.getInstance()
        val year = calendar[Calendar.YEAR]
        val month = calendar[Calendar.MONTH]
        val day = calendar[Calendar.DAY_OF_MONTH]
        val today = year.toString() + "" + month + "" + day
        val preferences = getSharedPreferences("PREFERENCES", 0)
        val currentDay = preferences.getBoolean(today, false)

        if (!currentDay) {
            Toast.makeText(this, "go work out now", Toast.LENGTH_SHORT).show()
            val editor = preferences.edit()
            editor.putBoolean(today, true)
            editor.apply()
        } else {
            Toast.makeText(this, "you already worked out", Toast.LENGTH_SHORT).show()
        }
    }
}
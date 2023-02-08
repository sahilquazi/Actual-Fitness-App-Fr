package com.example.exerme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val calendarButton = findViewById<Button>(R.id.calendarButton)

        calendarButton.setOnClickListener(View.OnClickListener { startActivity(Intent(this, CalendarActivity::class.java)) })
    }
}
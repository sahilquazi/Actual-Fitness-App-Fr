package com.example.exerme

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class StreakLog : AppCompatActivity() {
    private val sharedPreferences: SharedPreferences by lazy { applicationContext.getSharedPreferences("PREFERENCES2", MODE_PRIVATE) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_streak)

        val streakText = findViewById<TextView>(R.id.streakText)
        streakText.text = streak().toString()

        val dateFormat: DateFormat = SimpleDateFormat("MM-dd-yyyy", Locale.getDefault())
        val date = Date()
        val today = dateFormat.format(date)
        val yesterday = getYesterdayDate(dateFormat, date)
        val lastLoginDate = sharedPreferences.getString("last_login_date", null)

        if (lastLoginDate == null) {
            updateLastLoginDate(today)
            addDays()
        } else {
            if (lastLoginDate == yesterday) {
                updateLastLoginDate(today)
                addDays()
            } else {
                updateLastLoginDate(today)
                resetDays()
            }
        }
    }

    private fun getYesterdayDate(simpleDateFormat: DateFormat, date: Date): String {
        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar.add(Calendar.DATE, -1)
        return simpleDateFormat.format(calendar.time)
    }

    private fun updateLastLoginDate(date: String) {
        val editor = sharedPreferences.edit()
        editor.putString("last_login_date", date)
        editor.apply()
    }

    private fun getConsecutiveDays(): Int {
        var days = 0
        days = sharedPreferences.getInt("consecutive_days", 0)
        return days
    }

    private fun addDays() {
        val days = getConsecutiveDays() + 1
        val editor = sharedPreferences.edit()
        editor.putInt("consecutive_days", days)
        editor.apply()
    }

    private fun resetDays() {
        val days = 1
        val editor = sharedPreferences.edit()
        editor.putInt("consecutive_days", days)
        editor.apply()
    }

    private fun streak(): Int {
        return getConsecutiveDays()
    }
}
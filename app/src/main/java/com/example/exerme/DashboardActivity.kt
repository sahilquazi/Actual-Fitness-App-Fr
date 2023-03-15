package com.example.exerme

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


class DashboardActivity : AppCompatActivity() {
    private val channelID2 = "2"
    private val notificationId2 = 2
    private val sharedPreferences: SharedPreferences by lazy { applicationContext.getSharedPreferences("PREFERENCES2", MODE_PRIVATE) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        createNotificationChannel()

        val buttonCalendar = findViewById<Button>(R.id.calendarButton)
        buttonCalendar.setOnClickListener {
            val intent = Intent(this, CalendarActivity::class.java)
            startActivity(intent)
        }

        val dateFormat: DateFormat = SimpleDateFormat("MM-dd-yyyy", Locale.getDefault())
        val date = Date()
        val today = dateFormat.format(date)
        val yesterday = getYesterdayDate(dateFormat, date)
        val lastLoginDate = sharedPreferences.getString("last_login_date", null)

        if (lastLoginDate == null) {
            updateLastLoginDate(today)
            addDays()
            sendNotification()
        } else {
            if (lastLoginDate == yesterday) {
                updateLastLoginDate(today)
                addDays()
                sendNotification()
            } else {
                updateLastLoginDate(today)
                resetDays()
                sendNotification()
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

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelName = "Streak Notification"
            val channelDesc = "Send notification that updates every day when the user opens the app"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelID2, channelName, importance).apply {
                description = channelDesc
            }

            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    @SuppressLint("MissingPermission")
    private fun sendNotification() {
        val intent = Intent(this, DashboardActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent =
            PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        val streakNotification = NotificationCompat.Builder(this, channelID2)
            .setSmallIcon(R.drawable.notification_icon)
            .setContentTitle("Exerme")
            .setContentText("Your streak is ${streak()} day(s)")
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

        with(NotificationManagerCompat.from(this)) {
            notify(notificationId2, streakNotification)
        }
    }
}
package com.example.exerme

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.exerme.databinding.ActivityCalendarBinding
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationCompat.*
import java.util.*



class CalendarActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCalendarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalendarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createNotificationChannel()

        val backButton = findViewById<Button>(R.id.btnQuiz)
        backButton.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }

        binding.btnNotification.setOnClickListener {
            sendNotification()
        }

        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
        }
    }

    private fun sendNotification() {
        val intent = Intent(this, Notification:: class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            this,
            1,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT)

        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val time = getDate()
        alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, time, pendingIntent)
    }

    private fun getDate(): Long {
        val calendar = Calendar.getInstance()
        val minute = binding.timePicker.minute
        val hour = binding.timePicker.hour
        val day = binding.datePicker.dayOfMonth
        val month = binding.datePicker.month
        val year = binding.datePicker.year

        calendar.set(year, month, day, hour, minute)
        return calendar.timeInMillis
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelName = "Notification Channel"
            val channelDesc = "Description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("channel", channelName, importance)
            channel.description = channelDesc

            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private var streakSaverToday = 0
    private val channelID = "1"

    var builder = NotificationCompat.Builder(this, channelID)
        .setSmallIcon(R.drawable.notification_icon)
        .setContentTitle("My notification")
        .setContentText("Lets goo your streak is $streakSaverToday" )
        .setStyle(
            BigTextStyle()
                .bigText("Click this to continue your streak!"))
        .setPriority(PRIORITY_DEFAULT)
}
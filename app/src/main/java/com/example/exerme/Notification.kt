package com.example.exerme

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat

class Notification : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val notification = NotificationCompat.Builder(this, "channel")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Exerme")
            .setContentText("Go work out now!")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val manager = context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(1, notification)
    }
}
package com.example.exerme

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class quizpagesahil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quizpage)


        val PREFS_NAME = "MyPrefsFile"

        val settings = getSharedPreferences(PREFS_NAME, 0)

        if (settings.getBoolean("my_first_time", true)) {
            //the app is being launched for first time, do something
            Log.d("Comments", "First time")

















































            // record the fact that the app has been started at least once
            settings.edit().putBoolean("my_first_time", false).commit()
        }

    }
}
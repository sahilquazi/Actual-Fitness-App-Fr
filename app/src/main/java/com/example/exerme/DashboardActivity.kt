package com.example.exerme

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore.Video.Thumbnails.VIDEO_ID
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView
class DashboardActivity : AppCompatActivity(), YouTubePlayer.OnInitializedListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val buttonCalendar = findViewById<Button>(R.id.calendarButton)
        buttonCalendar.setOnClickListener {
            val intent = Intent(this, CalendarActivity::class.java)
            startActivity(intent)
        }


        val playerView = findViewById<YouTubePlayerView>(R.id.youtube_player)
        playerView.initialize(getString(R.string.AIzaSyABImPKz_yPwZKp65R8za4nKLMKpahntAI), this)


        override fun onInitializationSuccess(
            provider: YouTubePlayer.Provider?,
            player: YouTubePlayer?,
            wasRestored: Boolean
        ) {
            if (!wasRestored) {
                player?.cueVideo(TJU2b5oh7bI)
            }
        }

        override fun onInitializationFailure(
            provider: YouTubePlayer.Provider?,
            errorReason: YouTubeInitializationResult?
        ) {
            if (errorReason?.isUserRecoverableError == true) {
                errorReason.getErrorDialog(this, 1)?.show()
            } else {
                Toast.makeText(this, "Error initializing YouTube player", Toast.LENGTH_LONG).show()
            }


        }
    }
}
package com.example.exerme

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.example.exerme.DashboardActivity.Companion.buttonClicked
import com.example.exerme.Preferences.Companion.difficultyMode


class VideoActivity : AppCompatActivity() {


    private lateinit var videoView1: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video1)

        val buttonDashboard = findViewById<Button>(R.id.ReturnToDashboard)
        buttonDashboard.setOnClickListener{
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }
        videoView1 = findViewById(R.id.videoView1)

        videoView1.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.$/buttonClicked))


        val mediaController1 = MediaController(this)
        mediaController1.setAnchorView(videoView1)
        videoView1.setMediaController(mediaController1)


        // Start playing the videos
        videoView1.pause()

        // Set click listeners for pausing each video
        videoView1.setOnClickListener {
            if (videoView1.isPlaying) {
                videoView1.pause()
            } else {
                videoView1.start()
            }
        }




    }
}

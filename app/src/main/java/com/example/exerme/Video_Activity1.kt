package com.example.exerme

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView





class Video_Activity1 : AppCompatActivity() {


    private lateinit var videoView1: VideoView
    private lateinit var videoView2: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video1)


        videoView1 = findViewById(R.id.videoView1)
        videoView2 = findViewById(R.id.videoView2)

        videoView1.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.easyfiveminone))
        videoView2.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.easyfivemintwo))

        val mediaController1 = MediaController(this)
        mediaController1.setAnchorView(videoView1)
        videoView1.setMediaController(mediaController1)

        val mediaController2 = MediaController(this)
        mediaController2.setAnchorView(videoView2)
        videoView2.setMediaController(mediaController2)

        // Start playing the videos
        videoView1.pause()
        videoView2.pause()

        // Set click listeners for pausing each video
        videoView1.setOnClickListener {
            if (videoView1.isPlaying) {
                videoView1.pause()
            } else {
                videoView1.start()
            }
        }

        videoView2.setOnClickListener {
            if (videoView2.isPlaying) {
                videoView2.pause()
            } else {
                videoView2.start()
            }
        }


    }
}

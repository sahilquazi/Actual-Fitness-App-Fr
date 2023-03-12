package com.example.exerme

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val buttonCalendar = findViewById<Button>(R.id.calendarButton)
        buttonCalendar.setOnClickListener {
            val intent = Intent(this, CalendarActivity::class.java)
            startActivity(intent)
        }





        String videoUrl = "https://media.geeksforgeeks.org/wp-content/uploads/20201217192146/Screenrecorder-2020-12-17-19-17-36-828.mp4?_=1";


            // Uri object to refer the
            // resource from the videoUrl
            Uri uri = Uri.parse(videoUrl);

            // sets the resource from the
            // videoUrl to the videoView
            videoView.setVideoURI(uri);

            // creating object of
            // media controller class
            MediaController mediaController = new MediaController(this);

            // sets the anchor view
            // anchor view for the videoView
            mediaController.setAnchorView(videoView);

            // sets the media player to the videoView
            mediaController.setMediaPlayer(videoView);

            // sets the media controller to the videoView
            videoView.setMediaController(mediaController);

            // starts the video
            videoView.start();
        }




    }
}
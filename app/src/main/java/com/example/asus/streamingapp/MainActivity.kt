package com.example.asus.streamingapp

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.net.Uri
import android.view.View
import android.widget.MediaController
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var playbackPosition = 0
    private val Url = "rtsp://184.72.239.149/vod/mp4:BigBuckBunny_175k.mov"

    private lateinit var mediaController : MediaController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediaController = MediaController(this)

        videoView.setOnPreparedListener{
            mediaController.setAnchorView(videoContainer)
            videoView.setMediaController(mediaController)
            videoView.seekTo(playbackPosition)
            videoView.start()
        }

        videoView.setOnInfoListener { player, what, extras ->
            if(what == MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START)
                progressBar.visibility = View.INVISIBLE
            true
        }

        txtMarquee.isSelected = true
    }

    override fun onStart(){
        super.onStart()

        var uri = Uri.parse(Url)
        videoView.setVideoURI(uri)
        progressBar.visibility = View.VISIBLE
    }

    override fun onPause() {
        super.onPause()

        videoView.pause()
        playbackPosition = videoView.currentPosition
    }

    override fun onStop(){
        videoView.stopPlayback()

        super.onStop()
    }
}

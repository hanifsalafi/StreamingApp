package com.example.asus.streamingapp

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.net.Uri
import android.os.Handler
import android.view.View
import android.widget.MediaController
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    private var playbackPosition = 0
    private val Url = "http://ott.tvri.co.id/Content/HLS/Live/Channel(TVRINASIONAL)/index.m3u8"

    private lateinit var mediaController : MediaController

    private val SPLASH_TIME_OUT = 4000;

    private lateinit var Handler : Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediaController = MediaController(this)

        videoView.setVideoPath(Url)
        videoView.requestFocus()
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)
        videoView.start()

//      mediaController = MediaController(this)

//        videoView.setOnPreparedListener{
//            mediaController.setAnchorView(videoContainer)
//            videoView.setMediaController(mediaController)
//            videoView.seekTo(playbackPosition)
//            videoView.start()
//        }
//
//        videoView.setOnInfoListener { player, what, extras ->
//            if(what == MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START)
//                progressBar.visibility = View.INVISIBLE
//            true
//        }

        txtMarquee.isSelected = true
    }

//
//    override fun onStart(){
//        super.onStart()
//
//        var uri = Uri.parse(Url)
//        videoView.setVideoURI(uri)
//        progressBar.visibility = View.VISIBLE
//    }
//
//    override fun onPause() {
//        super.onPause()
//
//        videoView.pause()
//        playbackPosition = videoView.currentPosition
//    }
//
//    override fun onStop(){
//        videoView.stopPlayback()
//
//        super.onStop()
//    }
}

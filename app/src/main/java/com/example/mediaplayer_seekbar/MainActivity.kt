package com.example.mediaplayer_seekbar

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.SeekBar
import com.example.mediaplayer_seekbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mediaPlayer=MediaPlayer.create(this, R.raw.al_azhab)
        binding.seekbar.max=mediaPlayer.duration

        binding.seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                mediaPlayer.seekTo(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

        binding.btnStart.setOnClickListener {
            mediaPlayer.start()
        }
        binding.btnPause.setOnClickListener {
            mediaPlayer.pause()
        }
    }

    fun seekBarChanged(){
        handler= Handler(Looper.getMainLooper())
        handler.postDelayed(runnable, 1000)
    }

    val runnable=object : Runnable{
        override fun run() {
            binding.seekbar.progress=mediaPlayer.currentPosition
            handler.postDelayed(this, 1000)
        }

    }
}
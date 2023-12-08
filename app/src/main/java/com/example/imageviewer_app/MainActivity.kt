package com.example.imageviewer_app

import android.animation.ObjectAnimator
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageIds = arrayOf(R.drawable.bird, R.drawable.cat, R.drawable.dog)

        val imageView = findViewById<ImageView>(R.id.imageView)
        var index = 0

        val fade_in = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val fade_out = AnimationUtils.loadAnimation(this, R.anim.fade_out)

        findViewById<Button>(R.id.button_middle)
            .setOnClickListener{
                Log.d("BUTTONS", "User clicked middle button")

                imageView.startAnimation(fade_out)
                imageView.setImageResource(R.drawable.moose)
                imageView.startAnimation(fade_in)
            }

        findViewById<Button>(R.id.button_left)
            .setOnClickListener{
                Log.d("BUTTONS", "User clicked left button")
                if (index < 1){
                    index = 2
                }
                else
                    index--

                imageView.startAnimation(fade_out)
                imageView.setImageResource(imageIds[index])
                imageView.startAnimation(fade_in)
            }

        findViewById<Button>(R.id.button_right)
            .setOnClickListener{
                Log.d("BUTTONS", "User clicked right button")
                if (index > 1){
                    index = 0
                }
                else
                    index++

                imageView.startAnimation(fade_out)
                imageView.setImageResource(imageIds[index])
                imageView.startAnimation(fade_in)
            }




    }
}
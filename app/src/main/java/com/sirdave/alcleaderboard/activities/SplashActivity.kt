package com.sirdave.alcleaderboard.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.sirdave.alcleaderboard.R

class SplashActivity : AppCompatActivity() {
    private lateinit var imageView : ImageView
    private val splashTime: Long = 3000
    private lateinit var handler : Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        imageView = findViewById(R.id.splash_image)

        Glide.with(this)
            .load(R.drawable.gads_header)
            .into(imageView)

        handler = Handler()
        handler.postDelayed({loadSplashScreen()}, splashTime)
    }

    private fun loadSplashScreen() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}

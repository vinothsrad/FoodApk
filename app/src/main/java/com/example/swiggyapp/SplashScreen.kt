package com.example.swiggyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val iv_note=findViewById<ImageView>(R.id.SplashImg)
        val iv_text=findViewById<TextView>(R.id.tv_name)
        iv_text.alpha=0f
        iv_note.alpha=0f
        iv_text.animate().setDuration(1700).alpha(1f).withEndAction{
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
        }
        iv_note.animate().setDuration(1700).alpha(1f).withEndAction{
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }

    }
}
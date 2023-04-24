package com.example.tdgjsn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import kotlin.system.measureTimeMillis


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

val screeSplash = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        screeSplash.setKeepOnScreenCondition{true}
        val intent = Intent(this, homeActivity::class.java)
        startActivity(intent)
        finish()



    }
}
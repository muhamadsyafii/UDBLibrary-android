package com.ransyadev.udblibrary.ui.splashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.ransyadev.udblibrary.R
import com.ransyadev.udblibrary.ui.home.HomeActivity
import com.ransyadev.udblibrary.utils.openActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler(Looper.getMainLooper()).postDelayed({
            openActivity(HomeActivity::class.java)
            finish()
        }, 1500L)
    }
}

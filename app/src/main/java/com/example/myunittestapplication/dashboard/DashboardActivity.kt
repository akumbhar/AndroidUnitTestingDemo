package com.example.myunittestapplication.dashboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myunittestapplication.R

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.apply {
            hide()
        }
        setContentView(R.layout.dashboard)
    }
}
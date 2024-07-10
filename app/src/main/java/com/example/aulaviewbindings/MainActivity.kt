package com.example.aulaviewbindings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aulaviewbindings.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val activityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityMainBinding.root)

        with(activityMainBinding) {
            button3?.setOnClickListener { }
            button?.setOnClickListener { }
            button2?.setOnClickListener { }
        }
    }
}
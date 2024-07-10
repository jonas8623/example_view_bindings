package com.example.aulaviewbindings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.example.aulaviewbindings.databinding.ActivityFloatingActionButtonBinding

class FloatingActionButtonActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFloatingActionButtonBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_floating_action_button)
        setContentView(binding.root)

        with(binding) {
            floatingActionButton.setOnClickListener {
                groupId.visibility = if (groupId.isVisible) {
                    View.GONE
                } else {
                    View.VISIBLE
                }
            }
        }
    }
}
package com.mdapp.animatedvectordrawble

import android.graphics.drawable.Animatable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mdapp.animatedvectordrawble.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var animatable: Animatable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        animatable = binding.animatedImageView.drawable as Animatable
    }

    override fun onStart() {
        super.onStart()
        binding.startButton.setOnClickListener {
            animatable.start()
        }
    }
}
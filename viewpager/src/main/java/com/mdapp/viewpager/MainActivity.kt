package com.mdapp.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mdapp.viewpager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var adapter: MyFragmentPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = MyFragmentPagerAdapter(supportFragmentManager)
        binding.viewPager.adapter = adapter
    }
}
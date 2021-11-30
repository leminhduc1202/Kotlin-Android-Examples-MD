package com.mdapp.listadapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mdapp.listadapter.adapter.LanguageAdapter
import com.mdapp.listadapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var languagesAdapter: LanguageAdapter
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.getLanguageList().observe(this, Observer {
            languagesAdapter.submitList(it)
        })
        languagesAdapter = LanguageAdapter()
        val linearLayoutManager = LinearLayoutManager(this).apply {
            orientation = RecyclerView.VERTICAL
        }
        binding.languagesRecyclerView.layoutManager = linearLayoutManager
        val dividerItemDecoration =
            DividerItemDecoration(
                binding.languagesRecyclerView.context,
                linearLayoutManager.orientation
            )
        binding.languagesRecyclerView.addItemDecoration(dividerItemDecoration)
        binding.languagesRecyclerView.adapter = languagesAdapter
        binding.swipeRefreshLayout.setOnRefreshListener {
            mainViewModel.refreshList()
            binding.swipeRefreshLayout.isRefreshing = false
        }

    }
}
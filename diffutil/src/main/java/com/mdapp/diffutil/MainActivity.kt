package com.mdapp.diffutil

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mdapp.diffutil.databinding.ActivityMainBinding
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {

    private lateinit var contactAdapter: ContactsAdapter
    private lateinit var binding: ActivityMainBinding

    companion object {
        val log = Logger.getLogger(MainActivity::class.java.name)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val linearLayoutManager = LinearLayoutManager(applicationContext)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.recyclerViewMain.layoutManager = linearLayoutManager

        val dataSource = DataSource()
        contactAdapter = ContactsAdapter(applicationContext, dataSource.getData())
        binding.recyclerViewMain.adapter = contactAdapter

        val dividerItemDecoration =
            DividerItemDecoration(binding.recyclerViewMain.context, linearLayoutManager.orientation)
        binding.recyclerViewMain.addItemDecoration(dividerItemDecoration)

        binding.swipeFreshLayout.setOnRefreshListener {
            contactAdapter.updateData(dataSource.getUpdatedData())
            log.info(dataSource.getUpdatedData()[0].status)
            binding.swipeFreshLayout.isRefreshing = false
        }
    }
}
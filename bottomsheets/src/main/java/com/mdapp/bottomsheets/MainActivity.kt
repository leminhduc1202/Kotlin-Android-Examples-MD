package com.mdapp.bottomsheets

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.tabs.TabLayout
import com.mdapp.bottomsheets.databinding.ActivityMainBinding
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var sheetBehavior: BottomSheetBehavior<*>? = null

    companion object {
        val log = Logger.getLogger(MainActivity::class.java.name)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        binding.toolbar.setTitleTextColor(Color.WHITE)
        sheetBehavior = BottomSheetBehavior.from(findViewById(R.id.bottom_sheet_layout))
        sheetBehavior?.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {


            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                log.info("On Slide")
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                log.info("On State changes")
            }

        })
        findViewById<TabLayout>(R.id.tab_layout).addTab(
            findViewById<TabLayout>(R.id.tab_layout).newTab()
                .setIcon(R.drawable.ic_location_on_grey_600_24dp)
        )
        findViewById<TabLayout>(R.id.tab_layout).addTab(
            findViewById<TabLayout>(R.id.tab_layout).newTab()
                .setIcon(R.drawable.ic_directions_car_grey_700_24dp)
        )
        findViewById<TabLayout>(R.id.tab_layout).addTab(
            findViewById<TabLayout>(R.id.tab_layout).newTab()
                .setIcon(R.drawable.ic_directions_bus_grey_700_24dp)
        )
        val adapter = ViewPagerAdapter(supportFragmentManager)
        findViewById<ViewPager>(R.id.view_pager).adapter = adapter
        findViewById<ViewPager>(R.id.view_pager).addOnPageChangeListener(
            TabLayout
                .TabLayoutOnPageChangeListener(findViewById<TabLayout>(R.id.tab_layout))
        )
    }
}
package com.mdapp.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.mdapp.viewpager.viewpager.Page1
import com.mdapp.viewpager.viewpager.Page2

class MyFragmentPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment {
        if (position == 0) {
            return Page1()
        } else {
            return Page2()
        }
    }

    override fun getCount(): Int {
        return 2
    }

}
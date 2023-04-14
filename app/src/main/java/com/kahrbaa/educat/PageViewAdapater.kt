package com.kahrbaa.educat

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.kahrbaa.educat.fragments.Home

internal class PageViewAdapater(fm: FragmentManager) : FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                Home()
            }
            1 -> {
                Activity()
            }
            2 -> {
                Activity()
            }
            3 -> {
                Classroom()
            }
            else -> throw IllegalStateException("position $position is invalid for this viewpager")
        }
}
    override fun getCount(): Int {
        return 4
    }

}
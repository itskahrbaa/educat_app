package com.kahrbaa.educat

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.kahrbaa.educat.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mPageViewAdapater: PageViewAdapater



    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mPageViewAdapater = PageViewAdapater(supportFragmentManager)
        binding.mViewPager.adapter = mPageViewAdapater
        binding.mViewPager.offscreenPageLimit = 5

        binding.mViewPager.currentItem = 0
        binding.mViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int,
            ) {}

            override fun onPageSelected(position: Int) {
                binding.bottomNavigation.selectedItemId = when (position) {
                    0 -> R.id.home_page
                    1 -> R.id.search_page
                    2 -> R.id.activity
                    3 -> R.id.classroom
                    else -> throw IllegalStateException("position $position is invalid for this viewpager")
                }
            }

            override fun onPageScrollStateChanged(state: Int) {
            }

        })

        bottomnNav()
    }

    private fun bottomnNav() {
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.home_page -> {
                    binding.mViewPager.currentItem = 0
                }
                R.id.search_page -> {
                    binding.mViewPager.currentItem = 1

                }
                R.id.activity -> {
                    binding.mViewPager.currentItem = 2

                }
                R.id.classroom -> {
                    binding.mViewPager.currentItem = 3

                }
                else -> return@setOnItemSelectedListener false
            }
//            Toast.makeText(this@MainActivity, "item : $item", Toast.LENGTH_SHORT).show()
            true
        }
    }


}
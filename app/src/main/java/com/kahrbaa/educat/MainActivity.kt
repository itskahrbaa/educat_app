package com.kahrbaa.educat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.SimpleAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout.TabView
import com.kahrbaa.educat.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val courseData = ArrayList<Course>()
        navDepartment()
        in_progress(courseData)


    }

    private fun in_progress(arraydata: ArrayList<Course>) {

        arraydata.add(
            Course(
                "The Complete Dart Learning Guide [2022 Edition]",
                "A Complete Guide to the Dart Programming Language",
                40,
                WhoCreated("Hassan Fulaih", R.drawable.profileimg)
            )
        )

        var snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(binding.inProgress)

        binding.inProgress.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        binding.inProgress.adapter = InProgressAdapter(this, arraydata)
        binding.inProgress.isNestedScrollingEnabled = false

    }

    private fun navDepartment() {

    }


}
package com.kahrbaa.educat.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.kahrbaa.educat.Course
import com.kahrbaa.educat.InProgressAdapter
import com.kahrbaa.educat.R
import com.kahrbaa.educat.WhoCreated


class Home : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var tabLayout: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)
        val courseData = ArrayList<Course>()
        recyclerView = rootView.findViewById(R.id.in_progress)
        tabLayout = rootView.findViewById(R.id.tab_home)


        tabs()
        inProgressFun(rootView, courseData)
        return rootView
    }

    private fun tabs() {
        if (tabLayout.selectedTabPosition == 0) {
            Toast.makeText(context,"HELLLLLO",Toast.LENGTH_SHORT).show()
        }
        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab!!.position) {
                    0 -> {
                        Toast.makeText(context,tab!!.text,Toast.LENGTH_SHORT).show()
                    }
                    else -> {
                        println("TTT")
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}

        })
    }


    private fun inProgressFun(rootView: View, data: ArrayList<Course>) {

        data.add(
            Course(
                "The Complete Dart Learning Guide [2022 Edition]",
                "A Complete Guide to the Dart Programming Language",
                40,
                WhoCreated("Hassan Fulaih", R.drawable.profileimg)
            )
        )

        var snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)

        recyclerView.layoutManager =
            LinearLayoutManager(rootView.context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = InProgressAdapter(rootView.context, data)
        recyclerView.isNestedScrollingEnabled = false


    }

}

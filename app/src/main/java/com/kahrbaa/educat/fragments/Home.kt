package com.kahrbaa.educat.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import android.widget.Scroller
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.kahrbaa.educat.Course
import com.kahrbaa.educat.InProgressAdapter
import com.kahrbaa.educat.R
import com.kahrbaa.educat.WhoCreated


class Home : Fragment() {

    private lateinit var inProgress: RecyclerView
    private lateinit var homeFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (::inProgress.isInitialized.and(::homeFragment.isInitialized)) {
            inProgress.findViewById<RecyclerView>(R.id.in_progress)
            homeFragment = this
        }

        val courseData = ArrayList<Course>()
        inProgressFun(courseData)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    private fun inProgressFun(arraydata: ArrayList<Course>) {

        arraydata.add(
            Course(
                "The Complete Dart Learning Guide [2022 Edition]",
                "A Complete Guide to the Dart Programming Language",
                40,
                WhoCreated("Hassan Fulaih", R.drawable.profileimg)
            )
        )
        if (::inProgress.isInitialized.and(::homeFragment.isInitialized)) {

            var snapHelper = LinearSnapHelper()
            snapHelper.attachToRecyclerView(inProgress)

            inProgress.layoutManager =
                LinearLayoutManager(homeFragment.context, RecyclerView.HORIZONTAL, false)
            inProgress.adapter = InProgressAdapter(homeFragment.requireContext(), arraydata)
            inProgress.isNestedScrollingEnabled = false
        }
    }

}

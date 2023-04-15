package com.kahrbaa.educat.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.kahrbaa.educat.Course
import com.kahrbaa.educat.InProgressAdapter
import com.kahrbaa.educat.R
import com.kahrbaa.educat.WhoCreated


class Home : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)
        val courseData = ArrayList<Course>()

        courseData.add(
            Course(
                "The Complete Dart Learning Guide [2022 Edition]",
                "A Complete Guide to the Dart Programming Language",
                40,
                WhoCreated("Hassan Fulaih", R.drawable.profileimg)
            )
        )

        inProgressFun(rootView, courseData)
        return rootView
    }


    private fun inProgressFun(rootView: View, data: ArrayList<Course>) {

        val recycler: RecyclerView = rootView.findViewById(R.id.in_progress)

        var snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(recycler)

        recycler.layoutManager =
            LinearLayoutManager(rootView.context, LinearLayoutManager.HORIZONTAL, false)
        recycler.adapter = InProgressAdapter(rootView.context, data)
        recycler.isNestedScrollingEnabled = false
    }

}

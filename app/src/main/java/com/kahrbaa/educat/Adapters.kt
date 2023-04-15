package com.kahrbaa.educat

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.progressindicator.LinearProgressIndicator
import androidx.recyclerview.widget.RecyclerView


class InProgressAdapter(private val context: Context, private val data: ArrayList<Course>) : RecyclerView.Adapter<InProgressAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context)
            .inflate(R.layout.inprogress_coures, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = data[position].titleCourse
        holder.creator.text = data[position].createBy.name
        holder.thumbnail.setImageResource(data[position].createBy.image)
        holder.progress.progress = data[position].inProgress

        holder.itemView.setOnClickListener {
            Toast.makeText(context, data[position].description, Toast.LENGTH_LONG).show()
        }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val thumbnail: ImageView = itemView.findViewById(R.id.c_thumbnill)
        val creator: TextView = itemView.findViewById(R.id.c_creator)
        val title: TextView = itemView.findViewById(R.id.c_title)
        val progress: LinearProgressIndicator = itemView.findViewById(R.id.c_progress)

    }
}
package com.example.jopfinderapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class JobAdapter(private val myList:List<jobDescription>):
    ListAdapter<jobDescription, JobViewHolder>(DIFF) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.job_view,parent,false)
        return JobViewHolder(view)
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        val job=myList[position]
        holder.bindingData(job)
    }


    override fun getItemCount(): Int {
        return myList.size
    }


    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<jobDescription>() {
            override fun areItemsTheSame(oldItem: jobDescription, newItem: jobDescription): Boolean {
                return oldItem.position == newItem.position
            }

            override fun areContentsTheSame(
                oldItem: jobDescription,
                newItem: jobDescription
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}
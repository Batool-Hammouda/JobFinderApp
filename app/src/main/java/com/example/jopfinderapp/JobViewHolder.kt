package com.example.jopfinderapp

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.Locale

class JobViewHolder(item: View) : RecyclerView.ViewHolder(item) {
    private val position: TextView = item.findViewById(R.id.position)
    private val salary: TextView = item.findViewById(R.id.salary)
    private val company: TextView = item.findViewById(R.id.company)
    private val logo: ImageView = item.findViewById(R.id.logo)
    private val date: TextView = item.findViewById(R.id.date)

    @SuppressLint("SetTextI18n")
    fun bindingData(job: jobDescription) {
        position.text = job.position
        salary.text = "Salary $ ${job.salary} /month"
        company.text = job.company
        val inputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH)
        val outputFormat = SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH)
        val validDate = inputFormat.parse(job.publishDate)
        val formattedDate = outputFormat.format(validDate)
        date.text = formattedDate
        logo.setImageResource(job.image)
    }
}

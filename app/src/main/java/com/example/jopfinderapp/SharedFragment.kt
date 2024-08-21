package com.example.jopfinderapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SharedFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_shared, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listOfJobs = listOf(
            jobDescription(
                "UI/UX",
                "Gojek",
                800.00,
                "1995-05-02 18:57:22",
                R.drawable.slack_logo_svgrepo_com
            ),
            jobDescription(
                "Frontend",
                "Gojek",
                900.00,
                "1995-05-02 18:57:22",
                R.drawable.linkedin_logo_svgrepo_com
            ),
            jobDescription(
                "Backend",
                "Gojek",
                800.00,
                "1995-05-02 18:57:22",
                R.drawable.slack_logo_svgrepo_com
            ),
            jobDescription(
                "Android",
                "Gojek",
                900.00,
                "1995-05-02 18:57:22",
                R.drawable.linkedin_logo_svgrepo_com
            )
        )
        val recyclerView: RecyclerView = view.findViewById(R.id.jobsRecyclerview)
        val adapter = JobAdapter(listOfJobs)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }
}

package com.sirdave.alcleaderboard.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.sirdave.alcleaderboard.R
import com.sirdave.alcleaderboard.adapters.LearningLeadersRecyclerAdapter
import com.sirdave.alcleaderboard.adapters.SkillIQRecyclerAdapter
import com.sirdave.alcleaderboard.core.LearnerServices
import com.sirdave.alcleaderboard.core.ServiceBuilder
import com.sirdave.alcleaderboard.core.SkillServices
import com.sirdave.alcleaderboard.models.Learners
import com.sirdave.alcleaderboard.models.Skills
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LearningLeadersFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: LearningLeadersRecyclerAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_learning_leaders, container, false)

        recyclerView = view.findViewById(R.id.learners_recycler_view)
        layoutManager = LinearLayoutManager(context!!, RecyclerView.VERTICAL, false)

        val learnerServices = ServiceBuilder().buildService(LearnerServices::class.java)
        val learnersRequest = learnerServices.getLearners()

        learnersRequest.enqueue(object: Callback<ArrayList<Learners>> {
            override fun onFailure(request: Call<ArrayList<Learners>>, t: Throwable) {
                Toast.makeText(context, "Failed to retrieve content, check your internet connection", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(request: Call<ArrayList<Learners>>, response: Response<ArrayList<Learners>>) {
                recyclerAdapter = LearningLeadersRecyclerAdapter(context!!, response.body()!!)
                recyclerView.adapter = recyclerAdapter
                recyclerView.layoutManager = layoutManager
            }
        })
        return view
    }
}
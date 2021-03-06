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
import com.sirdave.alcleaderboard.adapters.SkillIQRecyclerAdapter
import com.sirdave.alcleaderboard.core.APIServices
import com.sirdave.alcleaderboard.core.ServiceBuilder
import com.sirdave.alcleaderboard.models.Skills
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SkillIQFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: SkillIQRecyclerAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_skill_iq, container, false)
        recyclerView = view.findViewById(R.id.skill_recycler_view)
        layoutManager = LinearLayoutManager(context!!, RecyclerView.VERTICAL, false)

        val apiServices = ServiceBuilder().buildService(APIServices::class.java)
        val skillRequest = apiServices.getSkills()

        skillRequest.enqueue(object: Callback<ArrayList<Skills>>{
            override fun onFailure(request: Call<ArrayList<Skills>>, t: Throwable) {
                Toast.makeText(context, "Failed to retrieve content, check your internet connection", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(request: Call<ArrayList<Skills>>, response: Response<ArrayList<Skills>>) {
                recyclerAdapter = SkillIQRecyclerAdapter(context!!, response.body()!!)
                recyclerView.adapter = recyclerAdapter
                recyclerView.layoutManager = layoutManager
            }
        })

        return view
    }
}
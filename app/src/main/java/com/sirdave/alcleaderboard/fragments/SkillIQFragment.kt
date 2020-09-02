package com.sirdave.alcleaderboard.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.sirdave.alcleaderboard.R
import com.sirdave.alcleaderboard.adapters.SkillIQRecyclerAdapter
import com.sirdave.alcleaderboard.models.Skills

class SkillIQFragment : Fragment() {
    private var mSkills = ArrayList<Skills>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: SkillIQRecyclerAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_skill_iq, container, false)

        recyclerView = view.findViewById(R.id.skill_recycler_view)
        recyclerAdapter = SkillIQRecyclerAdapter(context!!, mSkills)
        layoutManager = LinearLayoutManager(context!!, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = recyclerAdapter
        return view
    }


}

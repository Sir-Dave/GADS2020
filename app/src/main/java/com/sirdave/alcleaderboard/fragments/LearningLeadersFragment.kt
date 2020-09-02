package com.sirdave.alcleaderboard.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.sirdave.alcleaderboard.R
import com.sirdave.alcleaderboard.adapters.LearningLeadersRecyclerAdapter
import com.sirdave.alcleaderboard.models.Learners


class LearningLeadersFragment : Fragment() {
    private var learners = ArrayList<Learners>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: LearningLeadersRecyclerAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_learning_leaders, container, false)

        recyclerView = view.findViewById(R.id.learners_recycler_view)
        recyclerAdapter = LearningLeadersRecyclerAdapter(context!!, learners)
        layoutManager = LinearLayoutManager(context!!, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = recyclerAdapter
        return view
    }


}

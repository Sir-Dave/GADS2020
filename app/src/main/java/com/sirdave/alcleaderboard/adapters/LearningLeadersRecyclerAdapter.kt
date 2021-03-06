package com.sirdave.alcleaderboard.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sirdave.alcleaderboard.R
import com.sirdave.alcleaderboard.models.Learners

class LearningLeadersRecyclerAdapter(context: Context, learners: ArrayList<Learners>) : RecyclerView.Adapter<LearningLeadersRecyclerAdapter.ViewHolder>(){

    private var mLearners = ArrayList<Learners>()
    private var mContext: Context

    init {
        this.mContext = context
        this.mLearners = learners
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_top_learners, parent, false)
        val holder = ViewHolder(view)
        return holder

    }

    override fun getItemCount(): Int {
        return mLearners.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = mLearners[position]

        Glide.with(mContext).load(user.badgeUrl).into(holder.image)
        holder.name.text = user.name
        holder.country.text = user.country
        holder.hours.text = mContext.resources.getString(R.string.txt_learning_hours, user.hours)


    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var image: ImageView = itemView.findViewById(R.id.learner_image)
        var name : TextView = itemView.findViewById(R.id.userName)
        var hours : TextView = itemView.findViewById(R.id.learning_hours)
        var country : TextView = itemView.findViewById(R.id.country)
    }
}
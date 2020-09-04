package com.sirdave.alcleaderboard.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sirdave.alcleaderboard.R
import com.sirdave.alcleaderboard.models.Skills

class SkillIQRecyclerAdapter(context: Context, skills: ArrayList<Skills>): RecyclerView.Adapter<SkillIQRecyclerAdapter.ViewHolder>(){

    private var mSkills = ArrayList<Skills>()
    private var mContext: Context

    init {
        this.mContext = context
        this.mSkills = skills
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_top_skills, parent, false)
        val holder = ViewHolder(view)
        return holder
    }

    override fun getItemCount(): Int {
        return mSkills.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = mSkills[position]

        Glide.with(mContext).load(user.badgeUrl).into(holder.image)
        holder.name.text = user.name
        holder.country.text = user.country
        holder.skill_score.text = user.score
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var image: ImageView = itemView.findViewById(R.id.skill_image)
        var name : TextView = itemView.findViewById(R.id.userName)
        var skill_score : TextView = itemView.findViewById(R.id.skill_score)
        var country : TextView = itemView.findViewById(R.id.country)

    }
}
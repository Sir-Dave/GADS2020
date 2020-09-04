package com.sirdave.alcleaderboard.core

import com.sirdave.alcleaderboard.models.Skills
import retrofit2.Call
import retrofit2.http.GET

interface SkillServices {

    @GET("api/skilliq")
    fun getSkills() : Call<ArrayList<Skills>>

}
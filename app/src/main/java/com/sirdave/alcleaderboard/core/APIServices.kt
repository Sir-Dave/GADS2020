package com.sirdave.alcleaderboard.core

import com.sirdave.alcleaderboard.models.Learners
import com.sirdave.alcleaderboard.models.Skills
import retrofit2.Call
import retrofit2.http.GET

interface APIServices {

    @GET("api/hours")
    fun getLearners() : Call<ArrayList<Learners>>

    @GET("api/skilliq")
    fun getSkills() : Call<ArrayList<Skills>>
}
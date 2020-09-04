package com.sirdave.alcleaderboard.core

import com.sirdave.alcleaderboard.models.Learners
import retrofit2.Call
import retrofit2.http.GET

interface LearnerServices {
    @GET("api/hours")
    fun getLearners() : Call<ArrayList<Learners>>
}
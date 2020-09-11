package com.sirdave.alcleaderboard.core

import com.sirdave.alcleaderboard.models.Learners
import com.sirdave.alcleaderboard.models.Skills
import retrofit2.Call
import retrofit2.http.*

interface APIServices {

    @GET("api/hours")
    fun getLearners() : Call<ArrayList<Learners>>

    @GET("api/skilliq")
    fun getSkills() : Call<ArrayList<Skills>>

    @POST
    @FormUrlEncoded
    fun submitForm(
        @Url url: String,
        @Field("entry.1877115667") firstName: String,
        @Field("entry.2006916086") lastName: String,
        @Field("entry.1824927963") emailAddress: String,
        @Field("entry.284483984") githubLink: String
    ): Call<Void>
}
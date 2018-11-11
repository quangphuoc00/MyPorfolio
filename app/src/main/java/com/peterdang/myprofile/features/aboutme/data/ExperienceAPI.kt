package com.peterdang.myprofile.features.aboutme.data

import com.peterdang.myprofile.features.aboutme.models.ExperienceModel
import retrofit2.Call
import retrofit2.http.GET

internal interface ExperienceAPI {
    companion object {
        private const val VERSION = "v1"
        private const val EXPERIENCE_PATH = "/experiences.json"
    }

    @GET(EXPERIENCE_PATH)
    fun getData(): Call<List<ExperienceModel>>
}
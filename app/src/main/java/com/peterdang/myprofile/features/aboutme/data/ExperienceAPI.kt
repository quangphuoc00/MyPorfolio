package com.peterdang.myprofile.features.aboutme.data

import com.peterdang.myprofile.features.aboutme.models.ExperienceModel
import retrofit2.Call
import retrofit2.http.GET

internal interface ExperienceAPI {
    companion object {
        private const val VERSION = "v1.0su"
        private const val EXPERIENCE_PATH = "/46871c67c80b"
    }

    @GET(VERSION + EXPERIENCE_PATH)
    fun getData(): Call<List<ExperienceModel>>
}
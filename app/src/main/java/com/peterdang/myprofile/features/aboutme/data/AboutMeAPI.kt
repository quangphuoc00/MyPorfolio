package com.peterdang.myprofile.features.aboutme.data

import com.peterdang.myprofile.features.aboutme.models.ExperienceModel
import retrofit2.Call
import retrofit2.http.GET

internal interface AboutMeAPI {
    companion object {
        private const val VERSION = "v1"
        private const val EXPERIENCE_PATH = "/experiences.json"
        private const val SKILL_PATH = "/skills.json"
    }

    @GET(VERSION + EXPERIENCE_PATH)
    fun getExperiences(): Call<List<ExperienceModel>>

    @GET(VERSION + SKILL_PATH)
    fun getSkills(): Call<List<String>>
}
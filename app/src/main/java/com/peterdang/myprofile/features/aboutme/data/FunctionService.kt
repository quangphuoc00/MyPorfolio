package com.peterdang.myprofile.features.aboutme.data

import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExperienceService @Inject constructor(retrofit: Retrofit) : ExperienceAPI {
    private val funtioncApi by lazy { retrofit.create(ExperienceAPI::class.java) }

    override fun getData() = funtioncApi.getData()
}
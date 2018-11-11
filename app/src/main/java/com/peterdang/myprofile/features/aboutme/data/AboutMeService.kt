package com.peterdang.myprofile.features.aboutme.data

import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AboutMeService @Inject constructor(retrofit: Retrofit) : AboutMeAPI {
    private val aboutMeApi by lazy { retrofit.create(AboutMeAPI::class.java) }

    override fun getExperiences() = aboutMeApi.getExperiences()

    override fun getSkills() = aboutMeApi.getSkills()

}
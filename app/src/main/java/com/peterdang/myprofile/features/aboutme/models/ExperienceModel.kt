package com.peterdang.myprofile.features.aboutme.models

import com.google.gson.annotations.SerializedName

data class ExperienceModel (val company: String,
                            val role: String,
                            @SerializedName("working_period") val  workingPeriod: String,
                            val detail: String)
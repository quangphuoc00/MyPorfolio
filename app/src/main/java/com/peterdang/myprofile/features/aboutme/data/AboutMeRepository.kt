package com.peterdang.myprofile.features.aboutme.data

import com.peterdang.myprofile.core.blueprints.BaseRepository
import com.peterdang.myprofile.core.exception.Failure
import com.peterdang.myprofile.core.utils.Either
import com.peterdang.myprofile.core.utils.NetworkUtil
import com.peterdang.myprofile.features.aboutme.models.ExperienceModel
import javax.inject.Inject

interface AboutMeRepository : BaseRepository {
    fun getExperiences(): Either<Failure, List<ExperienceModel>>
    fun getSkills(): Either<Failure, List<String>>

    class Network
    @Inject constructor(private val networkUtil: NetworkUtil,
                        private val service: AboutMeService) : AboutMeRepository {
        override fun getSkills(): Either<Failure, List<String>> {
            return if (networkUtil.isNetworkAvailable())
                request(service.getSkills(),
                        emptyList())
            else
                Either.FailResult(Failure.NetworkConnection())        }

        override fun getExperiences(): Either<Failure, List<ExperienceModel>> {
            return if (networkUtil.isNetworkAvailable())
                request(service.getExperiences(),
                        emptyList())
            else
                Either.FailResult(Failure.NetworkConnection())
        }
    }
}
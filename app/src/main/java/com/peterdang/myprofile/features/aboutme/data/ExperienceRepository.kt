package com.peterdang.myprofile.features.aboutme.data

import com.peterdang.myprofile.core.blueprints.BaseRepository
import com.peterdang.myprofile.core.exception.Failure
import com.peterdang.myprofile.core.utils.Either
import com.peterdang.myprofile.core.utils.NetworkUtil
import com.peterdang.myprofile.features.aboutme.models.ExperienceModel
import javax.inject.Inject

interface ExperienceRepository : BaseRepository {
    fun getData(): Either<Failure, List<ExperienceModel>>

    class Network
    @Inject constructor(private val networkUtil: NetworkUtil,
                        private val service: ExperienceService) : ExperienceRepository {
        override fun getData(): Either<Failure, List<ExperienceModel>> {
            return if (networkUtil.isNetworkAvailable())
                request(service.getData(),
                        emptyList())
            else
                Either.FailResult(Failure.NetworkConnection())
        }
    }
}
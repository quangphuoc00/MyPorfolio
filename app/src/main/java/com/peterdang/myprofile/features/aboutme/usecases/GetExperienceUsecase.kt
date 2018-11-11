package com.peterdang.myprofile.features.aboutme.usecases

import com.peterdang.myprofile.core.interactor.UseCase
import com.peterdang.myprofile.features.aboutme.data.ExperienceRepository
import com.peterdang.myprofile.features.aboutme.models.ExperienceModel
import javax.inject.Inject

class GetExperienceUsecase
@Inject constructor(private val experienceRepository: ExperienceRepository) :
        UseCase<UseCase.None, List<ExperienceModel>>() {
    override suspend fun run(param: None) = experienceRepository.getData()
}
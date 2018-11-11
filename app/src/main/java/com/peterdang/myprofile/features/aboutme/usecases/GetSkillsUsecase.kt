package com.peterdang.myprofile.features.aboutme.usecases

import com.peterdang.myprofile.core.interactor.UseCase
import com.peterdang.myprofile.features.aboutme.data.AboutMeRepository
import javax.inject.Inject

class GetSkillsUsecase
@Inject constructor(private val aboutMeRepository: AboutMeRepository) :
        UseCase<UseCase.None, List<String>>() {
    override suspend fun run(param: None) = aboutMeRepository.getSkills()
}
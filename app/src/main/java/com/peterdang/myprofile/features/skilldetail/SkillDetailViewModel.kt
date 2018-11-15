package com.peterdang.myprofile.features.skilldetail;

import com.peterdang.myprofile.features.skilldetail.usecase.SkillDetailUseCase
import javax.inject.Inject
import com.peterdang.myprofile.core.blueprints.BaseViewModel

class SkillDetailViewModel
@Inject constructor(private val skilldetailUseCase: SkillDetailUseCase) : BaseViewModel() {
    override fun getFirstData() {

    }

}
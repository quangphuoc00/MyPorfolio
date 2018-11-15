package com.peterdang.myprofile.features.aboutme

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.peterdang.myprofile.BR
import com.peterdang.myprofile.R
import com.peterdang.myprofile.core.blueprints.BaseViewModel
import com.peterdang.myprofile.core.blueprints.ItemRecyclerViewClick
import com.peterdang.myprofile.core.interactor.UseCase
import com.peterdang.myprofile.features.aboutme.models.ExperienceModel
import com.peterdang.myprofile.features.aboutme.usecases.GetExperienceUsecase
import com.peterdang.myprofile.features.aboutme.usecases.GetSkillsUsecase
import me.tatarka.bindingcollectionadapter2.ItemBinding
import javax.inject.Inject

class AboutMeViewModel
@Inject constructor(private val getExperienceUsecase: GetExperienceUsecase,
                    private val getSkillsUsecase: GetSkillsUsecase) : BaseViewModel() {
    var experiences: ObservableList<ExperienceModel> = ObservableArrayList<ExperienceModel>()
    var skills: MutableLiveData<List<String>> = MutableLiveData()

    val onItemClick = object : ItemRecyclerViewClick<ExperienceModel> {
        override fun onItemClick(item: ExperienceModel) {

        }
    }

    val itemBinding: ItemBinding<ExperienceModel> = ItemBinding.of<ExperienceModel>(BR.row, R.layout.item_experience)
            .bindExtra(BR.listener, onItemClick)

    override fun getFirstData() {
        loadExperiences()
        loadSkills()
    }

    fun loadExperiences() {
        getExperienceUsecase(UseCase.None(), isLoading) {
            it.either(::handleFailure, ::handleLoadExperienceSuccess)
        }
    }

    fun loadSkills() {
        getSkillsUsecase(UseCase.None(), isLoading) {
            it.either(::handleFailure, ::handleLoadSkillsSucess)
        }
    }

    private fun handleLoadExperienceSuccess(listFunctions: List<ExperienceModel>) {
        this.experiences.addAll(listFunctions)
    }

    fun handleLoadSkillsSucess(listFunctions: List<String>) {
        this.skills.value = listFunctions
    }
}

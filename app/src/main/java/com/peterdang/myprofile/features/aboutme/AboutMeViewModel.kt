package com.peterdang.myprofile.features.aboutme

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import com.peterdang.myprofile.BR
import com.peterdang.myprofile.R
import com.peterdang.myprofile.core.blueprints.BaseViewModel
import com.peterdang.myprofile.core.blueprints.ItemRecyclerViewClick
import com.peterdang.myprofile.core.interactor.UseCase
import com.peterdang.myprofile.features.aboutme.models.ExperienceModel
import com.peterdang.myprofile.features.aboutme.usecases.GetExperienceUsecase
import me.tatarka.bindingcollectionadapter2.ItemBinding
import javax.inject.Inject

class AboutMeViewModel
@Inject constructor(private val getExperienceUsecase: GetExperienceUsecase) : BaseViewModel() {
    var experiences: ObservableList<ExperienceModel> = ObservableArrayList<ExperienceModel>()

    val onItemClick = object : ItemRecyclerViewClick<ExperienceModel> {
        override fun onItemClick(item: ExperienceModel) {

        }
    }

    val itemBinding: ItemBinding<ExperienceModel> = ItemBinding.of<ExperienceModel>(BR.row, R.layout.item_experience)
            .bindExtra(BR.listener, onItemClick)
    
    fun loadExperiences() {
        getExperienceUsecase(UseCase.None(), isLoading) {
            it.either(::handleFailure, ::handleLoadSuccess)
        }
    }

    private fun handleLoadSuccess(listFunctions: List<ExperienceModel>) {
        this.experiences.addAll(listFunctions)
    }
}

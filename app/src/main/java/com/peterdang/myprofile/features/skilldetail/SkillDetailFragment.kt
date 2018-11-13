package com.peterdang.myprofile.features.skilldetail;

import android.os.Bundle
import android.view.View

import com.peterdang.myprofile.R
import com.peterdang.myprofile.core.blueprints.BaseFragment
import com.peterdang.myprofile.core.extensions.fail
import com.peterdang.myprofile.core.extensions.observe
import com.peterdang.myprofile.core.extensions.viewModel
import javax.inject.Inject

class SkillDetailFragment : BaseFragment<SkillDetailViewModel>() {
    private val TAG = "SkillDetailFragment"

    override fun layoutId() = R.layout.fragment_skill_detail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)

        viewModel = viewModel(viewModelFactory) {
            //            observe(navFragment, ::Navigate)
            fail(failure, ::handleFailure)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModel.loadListFunction()
    }
}

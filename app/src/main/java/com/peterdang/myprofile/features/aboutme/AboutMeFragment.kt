package com.peterdang.myprofile.features.aboutme

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.peterdang.myprofile.R
import com.peterdang.myprofile.core.blueprints.BaseFragment
import com.peterdang.myprofile.core.extensions.fail
import com.peterdang.myprofile.core.extensions.observe
import com.peterdang.myprofile.core.extensions.viewModel
import com.peterdang.myprofile.core.navigation.MyNavigator
import com.peterdang.myprofile.core.ui.ItemOffsetDecoration
import kotlinx.android.synthetic.main.fragment_about_me.*
import javax.inject.Inject

class AboutMeFragment : BaseFragment<AboutMeViewModel>() {
    override fun layoutId() = R.layout.fragment_about_me

    @Inject
    lateinit var navigator: MyNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)

        viewModel = viewModel(viewModelFactory) {
            observe(skills, ::initChips)
            fail(failure, ::handleFailure)
        }
    }

    override fun setUpUI() {
        val gridLayoutManager = GridLayoutManager(context, 1, RecyclerView.HORIZONTAL, false)
        recyclerView.layoutManager = gridLayoutManager
        recyclerView.addItemDecoration(ItemOffsetDecoration(context!!, R.dimen.padding_normal))
    }

    private fun initChips(list: List<String>?) {
        if (list != null) {
            list.forEach { skillName ->
                run {
                    addChip(skillName, null)
                }
            }

            addChip(getString(R.string.see_more),
                    View.OnClickListener {
                        view?.let { navigator.goSkillDetail(it) }
                    })
        } else {
            val chip = Chip(chipGroup.context)
            chip.text = getString(R.string.cannot_load_skill_press_to_retry)

            // necessary to get single selection working
            chip.isClickable = true
            chip.setOnClickListener { viewModel.loadSkills() }
            chipGroup.addView(chip)
        }

    }

    private fun addChip(skillName: String,
                        eventClick: View.OnClickListener?) {
        val chip = Chip(chipGroup.context)
        chip.text = skillName

        // necessary to get single selection working
        chip.isCheckable = false
        chip.isClickable = eventClick != null

        eventClick?.let { chip.setOnClickListener(eventClick) }
        chipGroup.addView(chip)
    }
}

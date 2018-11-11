package com.peterdang.myprofile.features.aboutme

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.peterdang.myprofile.R
import com.peterdang.myprofile.core.blueprints.BaseFragment
import com.peterdang.myprofile.core.extensions.fail
import com.peterdang.myprofile.core.extensions.observe
import com.peterdang.myprofile.core.extensions.viewModel
import com.peterdang.myprofile.core.ui.ItemOffsetDecoration
import kotlinx.android.synthetic.main.fragment_about_me.*

class AboutMeFragment : BaseFragment<AboutMeViewModel>() {
    override fun layoutId() = R.layout.fragment_about_me

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)

        viewModel = viewModel(viewModelFactory) {
//            observe(navFragment, ::Navigate)
            fail(failure, ::handleFailure)
        }

    }

    fun setUpRecyclerView() {
        val gridLayoutManager = GridLayoutManager(context,1, RecyclerView.HORIZONTAL, false)
        recyclerView.layoutManager = gridLayoutManager
        recyclerView.addItemDecoration(ItemOffsetDecoration(context!!, R.dimen.padding_small))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
        getData()
    }

    private fun getData() {
        viewModel.loadExperiences()
    }

    override fun onRefresh(){
        getData()
    }
}

package com.peterdang.myprofile.features.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.peterdang.myprofile.R
import com.peterdang.myprofile.core.blueprints.BaseFragment

class DemoFragment : BaseFragment<DemoViewModel>() {
    override fun layoutId(): Int = R.layout.fragment_demo

    companion object {
        fun newInstance() = DemoFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DemoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}

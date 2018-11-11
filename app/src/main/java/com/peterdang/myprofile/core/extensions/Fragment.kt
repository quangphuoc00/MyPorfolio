package com.peterdang.myprofile.core.extensions

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.peterdang.myprofile.core.blueprints.BaseActivity
import com.peterdang.myprofile.core.blueprints.BaseFragment
import com.peterdang.myprofile.core.blueprints.BaseViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_about_me.*

inline fun <reified T : ViewModel> Fragment.viewModel(factory: ViewModelProvider.Factory, body: T.() -> Unit): T {
    val vm = ViewModelProviders.of(this, factory)[T::class.java]
    vm.body()
    return vm
}

val <T : BaseViewModel> BaseFragment<T>.viewContainer: Fragment
    get() = (activity as BaseActivity).fragmentContainer

val <T : BaseViewModel> BaseFragment<T>.appContext: Context
    get() = activity?.applicationContext!!

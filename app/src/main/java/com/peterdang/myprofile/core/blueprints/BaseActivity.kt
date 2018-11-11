package com.peterdang.myprofile.core.blueprints

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.peterdang.myprofile.BR
import com.peterdang.myprofile.MyApplication
import com.peterdang.myprofile.R
import com.peterdang.myprofile.core.di.ApplicationComponent
import com.peterdang.myprofile.core.exception.Failure
import com.peterdang.myprofile.core.extensions.viewContainer
import com.peterdang.myprofile.core.utils.NotifyUtil
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {

//    abstract fun layoutId(): Int
//
//    protected lateinit var viewModel: VM
//
//    @Inject
//    lateinit var viewModelFactory: ViewModelProvider.Factory
//    @Inject
//    lateinit var notifyUtil: NotifyUtil
//
//    private lateinit var dialog: ProgressDialog
//
//    internal fun firstTimeCreated(savedInstanceState: Bundle?) = savedInstanceState == null
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
//                              savedInstanceState: Bundle?): View? {
////        return inflater.inflate(layoutId(), container, false)
//        val binding: ViewDataBinding = DataBindingUtil.inflate(
//                inflater, layoutId(), container, false)
//        setBindingVariable(binding)
//        dialog = ProgressDialog(context)
//        dialog.setMessage(getString(R.string.loading))
//        return binding.root
//    }
//
//    protected open fun setBindingVariable(binding: ViewDataBinding) {
//        binding.setVariable(BR.viewmodel, viewModel)
//    }
//
//    protected fun handleFailure(failure: Failure?) {
//        when (failure) {
//            is Failure.NetworkConnection -> renderFailure(R.string.failure_network_connection)
//            is Failure.ServerError -> renderFailure(R.string.failure_server_error)
//        }
//    }
//
//    private fun renderFailure(@StringRes message: Int) {
//        notifyUtil.notifyWithAction(viewContainer, message, R.string.action_refresh, ::onRefresh)
//    }
//
//    protected fun showProgressDialog() {
//        dialog.show()
//    }
//
//    protected fun dimissProgressDialog() {
//        dialog.dismiss()
//    }
//
//    protected open fun onRefresh() {}
}
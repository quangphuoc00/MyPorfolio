package com.peterdang.myprofile.core.blueprints

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.peterdang.myprofile.BR
import com.peterdang.myprofile.MyApplication
import com.peterdang.myprofile.R
import com.peterdang.myprofile.core.di.ApplicationComponent
import com.peterdang.myprofile.core.exception.Failure
import com.peterdang.myprofile.core.extensions.viewContainer
import javax.inject.Inject
import com.peterdang.myprofile.core.utils.NotifyUtil


abstract class BaseFragment<VM : BaseViewModel> : Fragment(), LifecycleOwner {
    abstract fun layoutId(): Int

    protected lateinit var viewModel: VM

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (activity?.application as MyApplication).appComponent
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var notifyUtil: NotifyUtil

    internal fun firstTimeCreated(savedInstanceState: Bundle?) = savedInstanceState == null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: ViewDataBinding = DataBindingUtil.inflate(
                inflater, layoutId(), container, false)
        setBindingVariable(binding)
        return binding.root
    }

    protected open fun setBindingVariable(binding: ViewDataBinding) {
        binding.setVariable(BR.viewmodel, viewModel)
    }

    protected fun handleFailure(failure: Failure?) {
        when (failure) {
            is Failure.NetworkConnection -> renderFailure(R.string.failure_network_connection)
            is Failure.ServerError -> renderFailure(R.string.failure_server_error)
        }
    }

    private fun renderFailure(@StringRes message: Int) {
        notifyUtil.notifyWithAction(viewContainer, message, R.string.action_refresh, ::onRefresh)
    }

    protected open fun onRefresh() {
        viewModel.init()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpUI()
        viewModel.init()
    }

    /**
     * Write in onViewCreated method
     */
    protected open fun setUpUI(){}
}

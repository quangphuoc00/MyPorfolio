package com.peterdang.myprofile.core.blueprints

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.peterdang.myprofile.core.exception.Failure

/**
 * NOTE: Override BaseViewModel to have default Error handler
 */
abstract class BaseViewModel : ViewModel() {
    var failure: MutableLiveData<Failure> = MutableLiveData()
    var isLoading = ObservableBoolean()

    protected fun handleFailure(failure: Failure) {
        this.failure.value = failure
    }
}
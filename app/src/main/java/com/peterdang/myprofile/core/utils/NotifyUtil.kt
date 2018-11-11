package com.peterdang.myprofile.core.utils

import android.view.View
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.peterdang.myprofile.MyApplication
import com.peterdang.myprofile.R
import com.peterdang.myprofile.core.extensions.appContext
import com.peterdang.myprofile.core.extensions.viewContainer
import javax.inject.Inject

class NotifyUtil
@Inject constructor(private val appContext: MyApplication) {
    fun notify(viewContainer: Fragment,
               @StringRes message: Int) =
            viewContainer.view?.let { Snackbar.make(it, message, Snackbar.LENGTH_SHORT).show() }

    fun notify(viewContainer: Fragment,
               message: String) =
            viewContainer.view?.let { Snackbar.make(it, message, Snackbar.LENGTH_SHORT).show() }

    fun notifyWithAction(viewContainer: Fragment,
                         @StringRes message: Int,
                         @StringRes actionText: Int,
                         action: () -> Any) {
        val snackBar = viewContainer.view?.let { Snackbar.make(it, message, Snackbar.LENGTH_INDEFINITE) }
        if (snackBar != null) {
            snackBar.setAction(actionText) { _ -> action.invoke() }
            snackBar.setActionTextColor(ContextCompat.getColor(appContext,
                    R.color.colorPrimary))
            snackBar.show()
        }
    }
}
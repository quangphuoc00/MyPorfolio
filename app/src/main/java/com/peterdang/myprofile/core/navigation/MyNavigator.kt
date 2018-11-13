package com.peterdang.myprofile.core.navigation

import android.view.View
import androidx.navigation.Navigation
import com.peterdang.myprofile.R
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class MyNavigator
@Inject constructor() {


    private fun showLogin(fragment: View) {
//        val navController = Navigation.findNavController(fragment)
//        navController.navigate(R.id.event_details_fragment)
        //TODO add navigate to Login Page
    }

    fun showFragment(currentFragment: View, idFragment: Int) {
        val navController = Navigation.findNavController(currentFragment)
        navController.navigate(idFragment)
    }

    fun goSkillDetail(currentFragment: View) {
        val navController = Navigation.findNavController(currentFragment)
        navController.navigate(R.id.ActionSkillDetail)
    }
}


package com.peterdang.myprofile.core.extensions

import androidx.navigation.NavController
import androidx.navigation.ui.NavigationUI
import com.peterdang.curvebottomnavigationview.CubicCurveBottomNavigationView

fun NavigationUI.setupWithNavController(
        bottomNavigationView: CubicCurveBottomNavigationView,
        navController: NavController) {

    //Step 1
    bottomNavigationView.setOnNavigationItemSelectedListener { item -> NavigationUI.onNavDestinationSelected(item, navController) }

    //Step 2
    navController.addOnNavigatedListener { controller, destination ->
        val destinationId = destination.id
        val menu = bottomNavigationView.menu
        var h = 0
        val size = menu.size()
        while (h < size) {
            val item = menu.getItem(h)
            if (item.itemId == destinationId) {
                item.isChecked = true
            }
            h++
        }
    }
}
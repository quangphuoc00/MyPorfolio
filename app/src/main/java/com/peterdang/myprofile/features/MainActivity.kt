package com.peterdang.myprofile.features

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.peterdang.curvebottomnavigationview.CubicCurveBottomNavigationView
import com.peterdang.myprofile.R
import com.peterdang.myprofile.R.id.bottomNavigationView
import com.peterdang.myprofile.core.blueprints.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupNavigation()
    }

    private fun setupNavigation() {
        NavigationUI.setupWithNavController(bottomNavigationView,
                Navigation.findNavController(this, R.id.fragmentContainer))
    }

    override fun onSupportNavigateUp() =
            findNavController(this, R.id.fragmentContainer).navigateUp()


}

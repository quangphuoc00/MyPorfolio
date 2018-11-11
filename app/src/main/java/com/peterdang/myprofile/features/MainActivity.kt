package com.peterdang.myprofile.features

import android.os.Bundle
import android.view.ViewGroup
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
import com.peterdang.myprofile.core.utils.IntentUtil
import com.peterdang.myprofile.core.utils.NotifyUtil
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var intentUtil: IntentUtil

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

    fun sendEmail() {
        intentUtil.sendEmail()
    }
}

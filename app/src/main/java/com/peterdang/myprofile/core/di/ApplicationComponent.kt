package com.peterdang.myprofile.core.di

import com.peterdang.myprofile.core.di.viewmodel.ViewModelModule
import com.peterdang.myprofile.MyApplication
import com.peterdang.myprofile.features.MainActivity
import com.peterdang.myprofile.features.aboutme.AboutMeFragment
import com.peterdang.myprofile.features.demo.DemoFragment
import com.peterdang.myprofile.features.skilldetail.SkillDetailFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ViewModelModule::class, RepositoryModule::class])
interface ApplicationComponent {
    fun inject(application: MyApplication)
    fun inject(homeActivity: MainActivity)

    fun inject(fragment: DemoFragment)
    fun inject(fragment: AboutMeFragment)
    fun inject(fragment: SkillDetailFragment)
//    fun inject(blurFragment: BlurFragment)
}
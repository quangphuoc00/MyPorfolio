package com.peterdang.myprofile.core.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.peterdang.myprofile.features.aboutme.AboutMeViewModel
import com.peterdang.myprofile.features.demo.DemoViewModel
import com.peterdang.myprofile.features.skilldetail.SkillDetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(DemoViewModel::class)
    abstract fun bindsDemoViewModel(homeViewModel: DemoViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AboutMeViewModel::class)
    abstract fun bindsAboutMeViewModel(homeViewModel: AboutMeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SkillDetailViewModel::class)
    abstract fun bindsSkillDetailViewModel(homeViewModel: SkillDetailViewModel): ViewModel
}
package com.peterdang.myprofile.core.di

import com.peterdang.myprofile.features.aboutme.data.AboutMeRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideAboutMeRepository(dataSource: AboutMeRepository.Network): AboutMeRepository = dataSource
}
package com.peterdang.myprofile.core.di

import com.peterdang.myprofile.features.aboutme.data.ExperienceRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideExperienceRepository(dataSource: ExperienceRepository.Network): ExperienceRepository = dataSource
}
package com.sami.samfit.onboarding.di

import com.sami.samfit.onboarding.data.OnBoardingRepository
import com.sami.samfit.onboarding.domain.IonBoardingRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface GenderDomainModule {

    @Binds
    @Singleton
    fun provideOnBoardingRepository(repo: OnBoardingRepository): IonBoardingRepository
}

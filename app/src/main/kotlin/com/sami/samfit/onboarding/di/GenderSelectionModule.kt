package com.sami.samfit.onboarding.di

import android.content.Context
import androidx.room.Room
import com.sami.samfit.db.DatabaseConfig
import com.sami.samfit.db.SamfitDatabase
import com.sami.samfit.db.genderselection.GenderSelectionDao
import com.sami.samfit.onboarding.data.OnBoardingRepository
import com.sami.samfit.onboarding.domain.GetGenderUseCase
import com.sami.samfit.onboarding.domain.IonBoardingRepository
import com.sami.samfit.onboarding.domain.SaveGenderUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GenderSelectionModule {

    @Provides
    @Singleton
    fun provideSamfitDatabase(@ApplicationContext context: Context): SamfitDatabase =
        Room.databaseBuilder(context, SamfitDatabase::class.java, DatabaseConfig.name).build()

    @Provides
    @Singleton
    fun provideGenderEntityDao(samfitDatabase: SamfitDatabase): GenderSelectionDao =
        samfitDatabase.genderSelectionDao()

    @Module
    @InstallIn(SingletonComponent::class)
    interface GenderDomainModule {

        @Binds
        @Singleton
        fun provideOnBoardingRepository(repo: OnBoardingRepository): IonBoardingRepository

        @Binds
        @Singleton
        fun provideGetGenderUseCase(uc: GetGenderUseCase): GetGenderUseCase

        @Binds
        @Singleton
        fun provideSaveGenderUseCase(uc: SaveGenderUseCase): SaveGenderUseCase
    }
}

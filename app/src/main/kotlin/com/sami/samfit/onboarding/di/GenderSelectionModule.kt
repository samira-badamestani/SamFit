package com.sami.samfit.onboarding.di

import android.content.Context
import androidx.room.Room
import com.sami.samfit.db.DatabaseConfig
import com.sami.samfit.db.SamfitDatabase
import com.sami.samfit.db.genderselection.GenderSelectionDao
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
}
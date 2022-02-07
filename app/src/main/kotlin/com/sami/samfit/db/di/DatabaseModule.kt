package com.sami.samfit.db.di

import android.content.Context
import androidx.room.Room
import com.sami.samfit.db.DatabaseConfig
import com.sami.samfit.db.SamfitDatabase
import com.sami.samfit.db.difficultySelection.DifficultySelectionDao
import com.sami.samfit.db.genderselection.GenderSelectionDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideSamfitDatabase(@ApplicationContext context: Context): SamfitDatabase =
        Room.databaseBuilder(context, SamfitDatabase::class.java, DatabaseConfig.name).build()

    @Provides
    @Singleton
    fun provideGenderEntityDao(samfitDatabase: SamfitDatabase): GenderSelectionDao =
        samfitDatabase.genderSelectionDao()

    @Provides
    @Singleton
    fun provideDifficultyEntityDao(samfitDatabase: SamfitDatabase): DifficultySelectionDao =
        samfitDatabase.difficultyLevelDao()
}

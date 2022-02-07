package com.sami.samfit.difficultylevel.di

import com.sami.samfit.difficultylevel.data.DifficultyRepository
import com.sami.samfit.difficultylevel.domain.IDifficultyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DifficultyDomainModule {
    @Binds
    @Singleton
    fun provideDifficultyRepository(repo: DifficultyRepository): IDifficultyRepository
}

package com.sami.samfit.difficultylevel.domain

interface IDifficultyRepository {
    suspend fun saveDifficulty(data: DifficultyData)
}

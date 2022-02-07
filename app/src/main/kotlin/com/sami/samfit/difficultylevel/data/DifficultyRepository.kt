package com.sami.samfit.difficultylevel.data


import com.sami.samfit.db.difficultySelection.DifficultyEntity
import com.sami.samfit.db.difficultySelection.DifficultySelectionDao
import com.sami.samfit.difficultylevel.domain.DifficultyData
import com.sami.samfit.difficultylevel.domain.IDifficultyRepository
import javax.inject.Inject

class DifficultyRepository @Inject constructor(
    private val difficultyDao: DifficultySelectionDao
) : IDifficultyRepository {
    override suspend fun saveDifficulty(data: DifficultyData) {
        difficultyDao.saveDifficultySelection(DifficultyEntity(data.id, data.difficulty))
    }
}

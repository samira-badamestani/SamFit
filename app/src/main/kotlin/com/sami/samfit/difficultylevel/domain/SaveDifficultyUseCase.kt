package com.sami.samfit.difficultylevel.domain

import com.sami.samfit.difficultylevel.ui.DifficultyInputData
import javax.inject.Inject

class SaveDifficultyUseCase @Inject constructor(
    private val repository: IDifficultyRepository
) {
    suspend operator fun invoke(param: DifficultyInputData) {
        repository.saveDifficulty(DifficultyData(param.id, param.difficulty))
    }
}

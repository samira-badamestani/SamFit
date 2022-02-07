package com.sami.samfit.difficultylevel.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sami.samfit.difficultylevel.domain.SaveDifficultyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DifficultyViewModel @Inject constructor(
    private val saveDifficultyUseCase: SaveDifficultyUseCase
) : ViewModel() {
    fun saveDifficulty(difficulty: Difficulty) {
        viewModelScope.launch {
            saveDifficultyUseCase(difficulty.toEntity())
        }
    }
}

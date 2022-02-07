package com.sami.samfit.difficultylevel.ui

data class Difficulty(val type: DifficultyType = DifficultyType.BASIC)

enum class DifficultyType {
    BASIC, INTERMEDIATE, ADVANCED
}

fun Difficulty.toEntity(): DifficultyInputData = DifficultyInputData(1, difficulty = this.type.name)

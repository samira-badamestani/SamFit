package com.sami.samfit.db.difficultySelection

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DIFFICULTY_ENTITY_TABLE")
data class DifficultyEntity(
    @PrimaryKey
    val id: Int,
    val difficulty: String
)

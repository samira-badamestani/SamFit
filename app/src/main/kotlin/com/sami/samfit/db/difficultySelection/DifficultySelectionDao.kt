package com.sami.samfit.db.difficultySelection

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DifficultySelectionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveDifficultySelection(difficultyEntity: DifficultyEntity)

    @Query("SELECT * FROM DIFFICULTY_ENTITY_TABLE")
    suspend fun getDifficultyEntity(): List<DifficultyEntity>

    @Query("DELETE FROM DIFFICULTY_ENTITY_TABLE")
    suspend fun deleteDifficultyEntityTable()
}

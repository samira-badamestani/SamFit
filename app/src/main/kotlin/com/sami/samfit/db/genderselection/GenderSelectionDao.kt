package com.sami.samfit.db.genderselection

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GenderSelectionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveGenderSelection(genderEntity: GenderEntity)

    @Query("SELECT * FROM GENDER_ENTITY_TABLE")
    suspend fun getGenderEntity(): List<GenderEntity>

    @Query("DELETE FROM GENDER_ENTITY_TABLE")
    suspend fun deleteGenderEntityTable()
}
package com.sami.samfit.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sami.samfit.db.difficultySelection.DifficultyEntity
import com.sami.samfit.db.difficultySelection.DifficultySelectionDao
import com.sami.samfit.db.genderselection.GenderEntity
import com.sami.samfit.db.genderselection.GenderSelectionDao

@Database(entities = [GenderEntity::class, DifficultyEntity::class], version = DatabaseVersion.VERSION_1)
abstract class SamfitDatabase : RoomDatabase() {
    abstract fun genderSelectionDao(): GenderSelectionDao
    abstract fun difficultyLevelDao(): DifficultySelectionDao
}

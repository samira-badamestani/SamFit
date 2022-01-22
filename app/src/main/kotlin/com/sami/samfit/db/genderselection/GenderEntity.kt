package com.sami.samfit.db.genderselection

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "GENDER_ENTITY_TABLE")
data class GenderEntity(
    @PrimaryKey
    val id: Int,
    val gender: String
)
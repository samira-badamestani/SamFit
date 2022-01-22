package com.sami.samfit.onboarding.data

import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import com.sami.samfit.db.genderselection.GenderEntity

const val MALE = "MALE"
const val FEMALE = "FEMALE"

data class Gender(val type: GenderType = GenderType.UNKNOWN)

enum class GenderType {
    FEMALE, MALE, UNKNOWN
}

fun Gender.toEntity(): GenderEntity = GenderEntity(1, gender = this.type.name)

fun GenderEntity.toGender(): Gender = gender.toUpperCase(Locale.current).let {
    when (it) {
        MALE -> Gender(GenderType.MALE)
        FEMALE -> Gender(GenderType.FEMALE)
        else -> Gender(GenderType.UNKNOWN)
    }
}
package com.sami.samfit.onboarding.data

import com.sami.samfit.db.genderselection.GenderEntity
import com.sami.samfit.onboarding.domain.GenderData

object GenderDataMapper {
    fun fromGenderDaoData(data: GenderEntity): GenderData = GenderData(data.id, data.gender)
}

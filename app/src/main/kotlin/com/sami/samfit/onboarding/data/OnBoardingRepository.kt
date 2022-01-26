package com.sami.samfit.onboarding.data

import com.sami.samfit.db.genderselection.GenderEntity
import com.sami.samfit.db.genderselection.GenderSelectionDao
import com.sami.samfit.onboarding.data.GenderDataMapper.fromGenderDaoData
import com.sami.samfit.onboarding.domain.GenderData
import com.sami.samfit.onboarding.domain.IonBoardingRepository

class OnBoardingRepository(
    private val genderDao: GenderSelectionDao
) : IonBoardingRepository {
    override suspend fun getGender(): List<GenderData> {
        return genderDao.getGenderEntity().map { fromGenderDaoData(it) }
    }

    override suspend fun saveGender(data: GenderData) {
        genderDao.saveGenderSelection(GenderEntity(data.id, data.gender))
    }
}

package com.sami.samfit.onboarding.domain

import com.sami.samfit.onboarding.ui.GenderInputData
import javax.inject.Inject

class SaveGenderUseCase @Inject constructor(
    val repository: IonBoardingRepository
) {
    suspend operator fun invoke(param: GenderInputData) {
        repository.saveGender(GenderData(param.id, param.gender))
    }
}

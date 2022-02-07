package com.sami.samfit.onboarding.domain

import com.sami.samfit.onboarding.ui.GenderInputData
import javax.inject.Inject

class GetGenderUseCase @Inject constructor(
    private val repository: IonBoardingRepository
) {
    suspend operator fun invoke(): List<GenderInputData> {
        return repository.getGender().map { GenderInputData(it.id, it.gender) }
    }
}

package com.sami.samfit.onboarding.domain

interface IonBoardingRepository {
    suspend fun getGender(): List<GenderData>
    suspend fun saveGender(data: GenderData)
}

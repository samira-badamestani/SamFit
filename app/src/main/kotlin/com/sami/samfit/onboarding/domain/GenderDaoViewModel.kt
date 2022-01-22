package com.sami.samfit.onboarding.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sami.samfit.db.genderselection.GenderSelectionDao
import com.sami.samfit.onboarding.data.Gender
import com.sami.samfit.onboarding.data.toEntity
import com.sami.samfit.onboarding.data.toGender
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GenderDaoViewModel @Inject constructor(
    private val genderDao: GenderSelectionDao
) : ViewModel() {
    private val mutableGenderState: MutableStateFlow<Gender> = MutableStateFlow(Gender())

    val genderState: StateFlow<Gender>
        get() = mutableGenderState

    fun getGender() {
        viewModelScope.launch {
            genderDao.getGenderEntity()
                .let { genderEntityList ->
                    mutableGenderState.value =
                        genderEntityList.map { it.toGender() }.lastOrNull() ?: Gender()
                }
        }
    }

    fun setGender(gender: Gender) {
        viewModelScope.launch {
            genderDao.saveGenderSelection(gender.toEntity())
                .also { mutableGenderState.value = gender }
        }
    }

    init {
        getGender()
    }
}
package com.sami.samfit.onboarding.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sami.samfit.onboarding.domain.GetGenderUseCase
import com.sami.samfit.onboarding.domain.SaveGenderUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GenderViewModel @Inject constructor(
    private val getGenderUseCase: GetGenderUseCase,
    private val saveGenderUseCase: SaveGenderUseCase
) : ViewModel() {
    private val mutableGenderState: MutableStateFlow<Gender> = MutableStateFlow(Gender())

    val genderState: StateFlow<Gender>
        get() = mutableGenderState

    fun getGender() {
        viewModelScope.launch {
            getGenderUseCase()
                .let { genderEntityList ->
                    mutableGenderState.value =
                        genderEntityList.map { it.toGender() }.lastOrNull() ?: Gender()
                }
        }
    }

    fun setGender(gender: Gender) {
        viewModelScope.launch {
            saveGenderUseCase(gender.toEntity())
                .also { mutableGenderState.value = gender }
        }
    }

    init {
        getGender()
    }
}

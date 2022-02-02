package com.sami.samfit.onboarding.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.sami.samfit.onboarding.ui.GenderViewModel
import com.sami.samfit.theme.ui.standardPagePadding

@Composable
fun GenderSelectionScreen(
    viewModel: GenderViewModel
) {
    val selectedGender by viewModel.genderState.collectAsState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(standardPagePadding)
    ) {
        GenderSelectionBox(
            selectedGender.type,
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
                .align(Alignment.Center)
        ) {
            viewModel.setGender(it)
        }
    }
}

package com.sami.samfit.onboarding.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sami.samfit.R
import com.sami.samfit.onboarding.data.Gender
import com.sami.samfit.onboarding.data.GenderType
import com.sami.samfit.onboarding.domain.GenderDaoViewModel
import com.sami.samfit.theme.ui.VerticalSpace
import com.sami.samfit.theme.ui.standardContentMargin
import com.sami.samfit.theme.ui.standardPagePadding
import com.sami.samfit.theme.ui.typography

@Composable
fun GenderSelectionScreen(
    viewModel: GenderDaoViewModel
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

@Composable
private fun GenderSelectionBox(
    selectedGender: GenderType,
    modifier: Modifier,
    onGenderSelected: (Gender) -> Unit
) {
    Column(
        modifier = modifier
            .wrapContentWidth()
            .wrapContentHeight()
    ) {
        Text(
            text = getSelectedGenderText(
                selectedGender,
                stringResource(id = R.string.gender_select)
            ),
            style = typography.h4,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        VerticalSpace()

        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Box(
                modifier = Modifier
                    .width(80.dp)
                    .height(60.dp)
                    .background(colorResource(id = R.color.female))
                    .clickable { onGenderSelected(Gender(GenderType.FEMALE)) },
                contentAlignment = Alignment.Center
            ) {
                Text(text = stringResource(id = R.string.gender_female_text), color = Color.White)
            }
            Spacer(modifier = Modifier.width(standardContentMargin))
            Box(
                modifier = Modifier
                    .width(80.dp)
                    .height(60.dp)
                    .background(colorResource(id = R.color.male))
                    .clickable { onGenderSelected(Gender(GenderType.MALE)) },
                contentAlignment = Alignment.Center
            ) {
                Text(text = stringResource(id = R.string.gender_male_text), color = Color.White)
            }
        }
    }
}

private fun getSelectedGenderText(selectedGender: GenderType, defaultValue: String): String =
    if (selectedGender == GenderType.UNKNOWN) defaultValue else selectedGender.name
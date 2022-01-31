package com.sami.samfit.onboarding.ui.composable

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.sami.samfit.R
import com.sami.samfit.onboarding.ui.Gender
import com.sami.samfit.onboarding.ui.GenderType
import com.sami.samfit.theme.ui.SamFitTheme
import com.sami.samfit.theme.ui.VerticalSpace
import com.sami.samfit.theme.ui.standardContentMargin
import com.sami.samfit.theme.ui.typography

@Composable
fun GenderSelectionBox(
    selectedGender: GenderType,
    modifier: Modifier,
    onGenderSelected: (Gender) -> Unit = {}
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
            GenderSelectionButton(R.string.gender_female_text, R.color.female, Gender(GenderType.FEMALE)) {
                onGenderSelected(Gender(GenderType.FEMALE))
            }
            Spacer(modifier = Modifier.width(standardContentMargin))
            GenderSelectionButton(R.string.gender_male_text, R.color.male, Gender(GenderType.MALE)) {
                onGenderSelected(Gender(GenderType.MALE))
            }
        }
    }
}

private fun getSelectedGenderText(selectedGender: GenderType, defaultValue: String): String =
    if (selectedGender == GenderType.UNKNOWN) defaultValue else selectedGender.name

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GenderSelectionBoxPreview() {
    SamFitTheme {
        GenderSelectionBox(GenderType.FEMALE, Modifier)
    }
}

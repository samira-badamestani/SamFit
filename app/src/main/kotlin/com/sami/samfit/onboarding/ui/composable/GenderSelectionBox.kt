package com.sami.samfit.onboarding.ui.composable

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sami.samfit.R
import com.sami.samfit.onboarding.ui.*
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
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(
            text = stringResource(id = R.string.hi),
            style = typography.h4,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(bottom = 16.dp)
        )
        Text(
            text = getSelectedGenderText(
                selectedGender,
                stringResource(id = R.string.gender_select)
            ),
            style = typography.h6,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(bottom = 32.dp)
        )

        VerticalSpace()

        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            GenderSelectionButton(
                R.string.gender_female_text,
                R.drawable.ic_female,
                SelectedGenderObject(selectedGender, selectedGender.name == FEMALE),
                Gender(GenderType.FEMALE)
            ) {
                onGenderSelected(Gender(GenderType.FEMALE))
            }
            Spacer(modifier = Modifier.width(standardContentMargin))
            GenderSelectionButton(R.string.gender_male_text, R.drawable.ic_male, SelectedGenderObject(selectedGender, selectedGender.name == MALE), Gender(GenderType.MALE)) {
                onGenderSelected(Gender(GenderType.MALE))
            }
        }
        Button(
            onClick = { },
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(contentColor = colorResource(id = R.color.white), backgroundColor = colorResource(id = R.color.female)),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp, top = 32.dp)
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text(
                text = stringResource(id = R.string.next),
                style = typography.h6
            )
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

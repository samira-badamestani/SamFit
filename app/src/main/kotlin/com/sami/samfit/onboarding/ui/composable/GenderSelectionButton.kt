package com.sami.samfit.onboarding.ui.composable

import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sami.samfit.R
import com.sami.samfit.onboarding.ui.Gender
import com.sami.samfit.onboarding.ui.GenderType
import com.sami.samfit.theme.ui.SamFitTheme

@Composable
fun GenderSelectionButton(@StringRes title: Int, @ColorRes color: Int, gender: Gender, onGenderSelected: (Gender) -> Unit = {}) {
    Box(
        modifier = Modifier
            .width(80.dp)
            .height(60.dp)
            .background(colorResource(color))
            .clickable { onGenderSelected(gender) },
        contentAlignment = Alignment.Center
    ) {
        Text(text = stringResource(id = title), color = Color.White)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GenderSelectionButtonPreview() {
    SamFitTheme {
        GenderSelectionButton(R.string.gender_female_text, R.color.female, Gender(GenderType.FEMALE))
    }
}

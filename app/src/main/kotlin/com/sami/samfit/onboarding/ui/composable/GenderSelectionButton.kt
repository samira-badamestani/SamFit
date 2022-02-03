package com.sami.samfit.onboarding.ui.composable

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sami.samfit.onboarding.ui.Gender
import com.sami.samfit.onboarding.ui.GenderType
import com.sami.samfit.onboarding.ui.SelectedGenderObject

@Composable
fun GenderSelectionButton(
    @StringRes title: Int,
    @DrawableRes drawableRes: Int,
    selectedType: SelectedGenderObject,
    gender: Gender,
    onGenderSelected: (Gender) -> Unit = {}
) {
    Box(
        modifier = Modifier
            .width(150.dp)
            .wrapContentHeight(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(drawableRes), contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(150.dp)

            )
            Row(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = selectedType.isSelected,
                    colors = RadioButtonDefaults.colors(selectedColor = Color.White, unselectedColor = Color.White),
                    onClick = {
                        onGenderSelected(gender)
                    }
                )
                Text(
                    text = stringResource(id = title),
                    color = Color.White
                )
            }
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GenderSelectionButtonPreview() {

}

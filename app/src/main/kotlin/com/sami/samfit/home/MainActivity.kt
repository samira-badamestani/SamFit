package com.sami.samfit.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.res.colorResource
import com.sami.samfit.R
import com.sami.samfit.onboarding.ui.GenderViewModel
import com.sami.samfit.onboarding.ui.composable.GenderSelectionScreen
import com.sami.samfit.theme.ui.SamFitTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: GenderViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SamFitTheme {
                Surface(color = colorResource(R.color.purple_700)) {
                    GenderSelectionScreen(viewModel)
                }
            }
        }
    }
}

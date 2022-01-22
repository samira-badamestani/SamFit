package com.sami.samfit.onboarding.domain

import app.cash.turbine.test
import com.sami.samfit.db.genderselection.GenderEntity
import com.sami.samfit.db.genderselection.GenderSelectionDao
import com.sami.samfit.onboarding.data.FEMALE
import com.sami.samfit.onboarding.data.Gender
import com.sami.samfit.onboarding.data.GenderType
import com.sami.samfit.onboarding.data.MALE
import io.mockk.coEvery
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import kotlinx.coroutines.*
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
@DelicateCoroutinesApi
class GenderDaoViewModelTest {
    private val dao: GenderSelectionDao = mockk {
        coEvery { getGenderEntity() } returns listOf(GenderEntity(1, FEMALE))
        coEvery { saveGenderSelection(any()) } just runs
    }
    private val viewModel = GenderDaoViewModel(dao)

    // mainThreadSurrogate(https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-test/)
    // doesn't work with mockk
    private val mainThreadSurrogate = TestCoroutineDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset the main dispatcher to the original Main dispatcher
    }

    @Test
    fun `when viewModel#getGender is invoked - viewModel#genderState is updated`(): Unit =
        runBlocking {
            launch(Dispatchers.Main) {
                viewModel.getGender()
                viewModel.genderState.test {
                    assertEquals(FEMALE, awaitItem().type.name)
                }
            }
        }

    @Test
    fun `when viewModel#setGender is invoked - viewModel#genderState is updated`(): Unit =
        runBlocking {
            launch(Dispatchers.Main) {
                viewModel.getGender()
                viewModel.setGender(Gender(GenderType.MALE))
                viewModel.genderState.test {
                    assertEquals(MALE, awaitItem().type.name)
                }
            }
        }
}
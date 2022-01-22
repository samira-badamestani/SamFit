package com.sami.samfit.db

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sami.samfit.db.genderselection.GenderEntity
import com.sami.samfit.db.genderselection.GenderSelectionDao
import com.sami.samfit.onboarding.data.MALE
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(AndroidJUnit4::class)
class SamfitDatabaseTest {

    private lateinit var genderDao: GenderSelectionDao
    private lateinit var db: SamfitDatabase

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, SamfitDatabase::class.java).build()
        genderDao = db.genderSelectionDao()
    }

    @Test
    fun testAddGender() = runBlocking {
        genderDao.saveGenderSelection(GenderEntity(1, MALE))
        val result = genderDao.getGenderEntity()
        assertTrue(result.first().gender == MALE)
    }

    @Test
    fun testDeleteGender() = runBlocking {
        genderDao.saveGenderSelection(GenderEntity(1, MALE))
        val result = genderDao.getGenderEntity()
        assertTrue(result.first().gender == MALE)
        genderDao.deleteGenderEntityTable()

        val resultAfterDelete = genderDao.getGenderEntity()
        assertTrue(resultAfterDelete.isEmpty())
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }
}
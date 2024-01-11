package com.mehedi.bedaroomtest

import android.app.Application
import com.mehedi.bedaroomtest.db.BeedaDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class SurveyApp : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    // Initialize Room database
    val database by lazy { BeedaDB.getDatabase(this) }

    // Initialize SurveyRepository
    //  val repository by lazy { SurveyRepository(database.surveyResponseDao()) }

    // Initialize SurveyViewModel
    //val viewModel by lazy { SurveyViewModel(application = this, repository = repository) }
}
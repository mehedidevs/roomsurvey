package com.mehedi.bedaroomtest.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SurveyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSurveyQuestion(surveyQuestion: SurveyQuestionEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOption(option: OptionEntity)

    @Query("SELECT * FROM survey_questions")
    suspend fun getAllSurveyQuestions(): List<SurveyQuestionEntity>

    @Query("SELECT * FROM options WHERE qid = :qId")
    suspend fun getOptionsForSurveyQuestion(qId: Long): List<OptionEntity>
}
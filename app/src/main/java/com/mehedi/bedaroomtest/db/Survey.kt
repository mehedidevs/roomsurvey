package com.mehedi.bedaroomtest.db

import androidx.room.Entity
import androidx.room.PrimaryKey


data class SurveyQuestion(
    val id: Int,
    val question: String,
    val type: String,
    val options: List<Option>?,
    val referTo: Any? = null,
    val required: Boolean
)

data class Option(
    val value: String,
    val referTo: Any? = null
)


@Entity(tableName = "survey_questions")
data class SurveyQuestionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val question: String,
    val type: String,
    val referTo: Any?,
    val required: Boolean
)

@Entity(tableName = "options")
data class OptionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val qid: Long,
    val value: String,
    val referTo: Any?
)



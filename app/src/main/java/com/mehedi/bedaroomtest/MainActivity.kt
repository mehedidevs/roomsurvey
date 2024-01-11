package com.mehedi.bedaroomtest

import android.content.Context
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mehedi.bedaroomtest.databinding.ActivityMainBinding
import com.mehedi.bedaroomtest.db.BeedaDB
import com.mehedi.bedaroomtest.db.Option
import com.mehedi.bedaroomtest.db.OptionEntity
import com.mehedi.bedaroomtest.db.SurveyQuestion
import com.mehedi.bedaroomtest.db.SurveyQuestionEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    lateinit var database: BeedaDB

    lateinit var binding: ActivityMainBinding

    private val list: MutableList<MutableList<SurveyQuestion>> = mutableListOf()
    private var currentIndex = 0

    init {
        System.loadLibrary("native-lib")
    }


    companion object {
        @JvmStatic
        external fun apiUrl(): String
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.text = apiUrl()


        database = BeedaDB.getDatabase(this@MainActivity)


//        list[currentIndex].let {
//            SurveyAdapter(it).apply {
//                binding.rvSurvey.adapter = this
//
//            }
//        }


        GlobalScope.launch(Dispatchers.IO) {

            // list.add(0, getDataFromDatabase().toMutableList())

            Dummy.surveyQuestions.map {
                insertDataIntoDatabase(it)
            }
            getDataFromDatabase().map {

               // list[0][it.id] = it

                Log.d("TAG", "survey Question : $list ")
            }
        }
    }


    override fun onResume() {
        super.onResume()
       // BeedaDB.getDatabase(this).getDao().insertAllUser(Dummy.getDummyUserList())
    }

    suspend fun insertDataIntoDatabase(surveyQuestion: SurveyQuestion) {
        withContext(Dispatchers.IO) {

            val surveyDao = database.getSurveyDao()

            val surveyQuestionEntity = SurveyQuestionEntity(
                question = surveyQuestion.question,
                type = surveyQuestion.type,
                referTo = surveyQuestion.referTo,
                required = surveyQuestion.required
            )

            val optionEntities = surveyQuestion.options?.map { option ->
                OptionEntity(
                    qid = surveyQuestion.id.toLong(),
                    value = option.value,
                    referTo = option.referTo
                )
            }



            surveyDao.insertSurveyQuestion(surveyQuestionEntity)
            optionEntities?.forEach {
                surveyDao.insertOption(it)
            }

        }
    }

    suspend fun getDataFromDatabase(): List<SurveyQuestion> {

        val surveyDao = database.getSurveyDao()

        val surveyQuestionEntities = surveyDao.getAllSurveyQuestions()


        return surveyQuestionEntities.map { surveyQuestionEntity ->
            val options = surveyDao.getOptionsForSurveyQuestion(surveyQuestionEntity.id)
                .map { optionEntity ->
                    Option(value = optionEntity.value, referTo = optionEntity.referTo)
                }

            SurveyQuestion(
                id = surveyQuestionEntity.id.toInt(),
                question = surveyQuestionEntity.question,
                type = surveyQuestionEntity.type,
                options = options,
                referTo = surveyQuestionEntity.referTo,
                required = surveyQuestionEntity.required
            )
        }


    }
}



package com.mehedi.bedaroomtest.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mehedi.bedaroomtest.AnyTypeConverter

@Database(entities = [User::class, SurveyQuestionEntity::class, OptionEntity::class], version = 3)
@TypeConverters(AnyTypeConverter::class)
abstract class BeedaDB : RoomDatabase() {

    abstract fun getDao(): BedaDao
    abstract fun getSurveyDao(): SurveyDao

    companion object {
        private const val DATABASE_NAME = "beda_database"

        @Volatile
        private var INSTANCE: BeedaDB? = null

        fun getDatabase(context: Context): BeedaDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BeedaDB::class.java,
                    DATABASE_NAME
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                instance
            }
        }
    }


}
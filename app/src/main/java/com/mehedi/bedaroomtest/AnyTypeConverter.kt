package com.mehedi.bedaroomtest

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class AnyTypeConverter {

    @TypeConverter
    fun fromJson(json: String?): Any? {
        if (json == null) return null
        val type = object : TypeToken<Any>() {}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun toJson(value: Any?): String? {
        return Gson().toJson(value)
    }
}
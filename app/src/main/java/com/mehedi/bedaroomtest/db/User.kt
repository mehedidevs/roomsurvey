package com.mehedi.bedaroomtest.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Long=0,
    val name: String,
    val mobile: String,
    val zoneId: String,
    val bloodGroup: String

)

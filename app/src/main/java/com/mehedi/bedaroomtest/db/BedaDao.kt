package com.mehedi.bedaroomtest.db

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface BedaDao {

    @Insert
    fun insertAllUser(user: List<User>)


}
package com.example.mvm.Database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SubScriberDAO  {

    @Insert
   suspend fun insert(sub:Subscriber)
    @Update
  suspend  fun update(sub:Subscriber)
    @Query("SELECT * FROM subscribers")
   fun getAl():LiveData<List<Subscriber>>
    @Query("DELETE  FROM subscribers")
   suspend fun clear()

}
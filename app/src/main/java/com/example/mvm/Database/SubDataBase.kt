package com.example.mvm.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase



@Database(entities = [Subscriber::class,],version=1,exportSchema = false)
abstract class SubDataBase() : RoomDatabase() {
    abstract val subDao:SubScriberDAO
    companion object{

        @Volatile
        private var INSTANCE:SubDataBase?=null
        fun getInstance(context:Context):SubDataBase{
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SubDataBase::class.java,
                        "sleep_history_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }

        }
    }
}
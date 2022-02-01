package com.example.mvm.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="subscribers")
data class Subscriber(
    @PrimaryKey(autoGenerate = true)
    val id : Int =0 ,
    @ColumnInfo(name="name")

    val name :String,
    @ColumnInfo(name="Tittle")
    val tittle : String

)
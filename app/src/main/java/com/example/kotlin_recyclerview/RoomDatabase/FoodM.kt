package com.example.kotlin_recyclerview.RoomDatabase

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class FoodM(

  @ColumnInfo
    var name:String="",
  @ColumnInfo
    var image:String="",
  @ColumnInfo
    var description:String="",
  @ColumnInfo
    var Yields:String="",
  @ColumnInfo
    var totalTime:String="",
  @ColumnInfo
    var CalServ:String="",
    @PrimaryKey(autoGenerate = true)
    val id: Long =0): Parcelable

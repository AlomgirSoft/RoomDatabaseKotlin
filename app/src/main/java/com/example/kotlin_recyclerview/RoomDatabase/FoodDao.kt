package com.example.kotlin_recyclerview.RoomDatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface FoodDao {
   @Insert
    fun insertFood(food:FoodM)
   @Update
    fun updateFood(food: FoodM)
     @Delete
    fun deleteFood(foodM: FoodM)
   @Query("SELECT* FROM FoodM")
    fun getAllFood(): MutableList<FoodM>


}
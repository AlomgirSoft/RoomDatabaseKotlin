package com.example.kotlin_recyclerview.dbServiec

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.kotlin_recyclerview.models.FoodM

@Dao
interface FoodDao {
   @Insert
    suspend fun insertFood(food: FoodM)
   @Update
  suspend  fun updateFood(food: FoodM)
     @Delete
   suspend fun deleteFood(foodM: FoodM)
   @Query("SELECT* FROM FoodM")
    fun getAllFood(): LiveData<MutableList<FoodM>>


}
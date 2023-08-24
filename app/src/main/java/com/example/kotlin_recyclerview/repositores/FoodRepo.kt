package com.example.kotlin_recyclerview.repositores

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.example.kotlin_recyclerview.dbServiec.FoodDatabase
import com.example.kotlin_recyclerview.models.FoodM
import javax.inject.Inject

class FoodRepo  @Inject constructor(private val dbServiec:FoodDatabase)  {


    fun getAllFood(): LiveData<MutableList<FoodM>>{

        return dbServiec.getFoodDao().getAllFood()
    }



    suspend fun insertFood(food: FoodM){

        dbServiec.getFoodDao().insertFood(food)
    }

    suspend  fun updateFood(food: FoodM){

        dbServiec.getFoodDao().updateFood(food)
    }

    suspend fun deleteFood(foodM: FoodM){
        dbServiec.getFoodDao().deleteFood(foodM)
    }








}
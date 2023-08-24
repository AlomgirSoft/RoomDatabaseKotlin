package com.example.kotlin_recyclerview.dbServiec

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kotlin_recyclerview.models.FoodM

@Database( entities = [FoodM ::class], version = 1)
 abstract class FoodDatabase : RoomDatabase() {

     abstract fun getFoodDao(): FoodDao

     companion object{

         private var db: FoodDatabase?=null

         fun getInstance(context:Context): FoodDatabase {
             return if (db ===null){

                 db =Room.databaseBuilder(context, FoodDatabase::class.java,
                     "Food_Database")
                     .allowMainThreadQueries() .build()

                 db as FoodDatabase
             }else{
                 db as FoodDatabase
             }





         }



     }





}
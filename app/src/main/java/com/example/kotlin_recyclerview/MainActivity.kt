package com.example.kotlin_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_recyclerview.RoomDatabase.FoodDatabase
import com.example.kotlin_recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    lateinit var adapter: CountAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        DataS.foodList.forEach{
//
//
//            FoodDatabase.getInstance(this@MainActivity).getFoodDao().insertFood(it)
//
//        }


        adapter= CountAdapter(this@MainActivity,FoodDatabase.getInstance(this@MainActivity).getFoodDao().getAllFood())
        binding.recyclerview.adapter=adapter





    }
}
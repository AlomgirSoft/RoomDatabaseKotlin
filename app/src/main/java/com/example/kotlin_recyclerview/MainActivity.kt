package com.example.kotlin_recyclerview

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_recyclerview.RoomDatabase.FoodDatabase
import com.example.kotlin_recyclerview.RoomDatabase.FoodM
import com.example.kotlin_recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() ,CountAdapter.FoodItemListener {

    lateinit var binding: ActivityMainBinding

    lateinit var adapter: CountAdapter

    lateinit var foodItemListener: CountAdapter.FoodItemListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        DataS.foodList.forEach{
//
//
//            FoodDatabase.getInstance(this@MainActivity).getFoodDao().insertFood(it)
//
//        }


        setUpAdapterWithData()

        binding.floatingActionButton.setOnClickListener {
            startActivity(Intent(this@MainActivity, FoodDitailesActivity::class.java))
        }


        //=========================
    }


    private fun setUpAdapterWithData() {
        adapter = CountAdapter(
            this@MainActivity,
            FoodDatabase.getInstance(this@MainActivity).getFoodDao().getAllFood(),
            this@MainActivity
        )
        binding.recyclerview.adapter = adapter

    }

    override fun onRestart() {
        setUpAdapterWithData()
        super.onRestart()
    }

    override fun foodItemDelete(foodMore: FoodM) {
        FoodDatabase.getInstance(this).getFoodDao().deleteFood(foodMore)
    }

    override fun foodItemUpdate(foodUpdate: FoodM) {

        val  intent=Intent(this@MainActivity,FoodDitailesActivity::class.java)

             intent.putExtra(FoodDitailesActivity.KAY,foodUpdate)
            startActivity(intent)



    }

}
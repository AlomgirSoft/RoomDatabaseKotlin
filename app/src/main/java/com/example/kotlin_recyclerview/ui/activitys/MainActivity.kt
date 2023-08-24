package com.example.kotlin_recyclerview.ui.activitys

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_recyclerview.dbServiec.FoodDatabase
import com.example.kotlin_recyclerview.models.FoodM
import com.example.kotlin_recyclerview.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() , CountAdapter.FoodItemListener {

    lateinit var binding: ActivityMainBinding

    lateinit var adapter: CountAdapter

    lateinit var foodItemListener: CountAdapter.FoodItemListener
    private val viewModel:MainActivityViewModel by viewModels()


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

        viewModel.getAllFood().observe(this){

            adapter = CountAdapter(
                this@MainActivity,

                it,this@MainActivity

            )
            binding.recyclerview.adapter = adapter


        }




        binding.floatingActionButton.setOnClickListener {
            startActivity(Intent(this@MainActivity, FoodDitailesActivity::class.java))
        }


        //=========================
    }

    override fun foodItemDelete(foodMore: FoodM) {
        viewModel.deleteFood( foodMore)
    }

    override fun foodItemUpdate(foodUpdate: FoodM) {
        viewModel.updateFood(foodUpdate)

        val  intent=Intent(this@MainActivity, FoodDitailesActivity::class.java)

        intent.putExtra(FoodDitailesActivity.KAY,foodUpdate)
        startActivity(intent)
    }


}



//    override fun foodItemDelete(foodMore: FoodM) {
//        FoodDatabase.getInstance(this).getFoodDao().deleteFood(foodMore)
//        viewModel.
//
//    }
//
//    override fun foodItemUpdate(foodUpdate: FoodM) {
//
//        val  intent=Intent(this@MainActivity, FoodDitailesActivity::class.java)
//
//             intent.putExtra(FoodDitailesActivity.KAY,foodUpdate)
//            startActivity(intent)
//
//    }







package com.example.kotlin_recyclerview.ui.activitys

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_recyclerview.models.FoodM
import com.example.kotlin_recyclerview.repositores.FoodRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repo:FoodRepo):ViewModel() {


    fun getAllFood(): LiveData<MutableList<FoodM>>{
       return repo.getAllFood()
    }

    fun deleteFood(foodM: FoodM) {
        viewModelScope.launch {
            repo.deleteFood(foodM)
        }
    }



      fun updateFood(food: FoodM) {
          viewModelScope.launch {
              repo.updateFood(food)
          }




      }
    }
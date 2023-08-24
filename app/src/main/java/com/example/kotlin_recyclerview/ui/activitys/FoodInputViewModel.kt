package com.example.kotlin_recyclerview.ui.activitys

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_recyclerview.models.FoodM
import com.example.kotlin_recyclerview.repositores.FoodRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodInputViewModel @Inject constructor(private val repo:FoodRepo):ViewModel() {



    fun updateFood(food: FoodM) {
        viewModelScope.launch {
            repo.updateFood(food)
        }




    }
    fun insertFood(food: FoodM){
        viewModelScope.launch {
         repo.insertFood(food)
        }
    }


}
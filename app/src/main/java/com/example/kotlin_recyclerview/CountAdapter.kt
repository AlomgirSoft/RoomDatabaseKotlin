package com.example.kotlin_recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.kotlin_recyclerview.RoomDatabase.FoodM
import com.example.kotlin_recyclerview.databinding.ItemCountBinding

class CountAdapter (var context:Context, var veganFoodList:MutableList<FoodM>): RecyclerView.Adapter<CountAdapter.CountViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountViewHolder {

       return CountViewHolder(ItemCountBinding.inflate(LayoutInflater.from(context),parent,false))
    }
    override fun onBindViewHolder(holder: CountViewHolder, position: Int) {

        veganFoodList[position].let {


            holder.binding.apply {

                foodNameTv.text=it.name
                foodDescriptionTv.text=it.description
                yieldsResult.text=it.Yields
                totaltimeResult.text=it.totalTime
                prodcutId.text="Product ID NO: "+it.id
                calServResult.text=it.CalServ

                foodImage.load(it.image)

            }



        }






    }




    override fun getItemCount(): Int {
        return veganFoodList.size

    }


    class CountViewHolder (var binding:ItemCountBinding): RecyclerView.ViewHolder(binding.root)

}
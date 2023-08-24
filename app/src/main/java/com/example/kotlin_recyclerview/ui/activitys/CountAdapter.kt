package com.example.kotlin_recyclerview.ui.activitys

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.kotlin_recyclerview.R
import com.example.kotlin_recyclerview.models.FoodM
import com.example.kotlin_recyclerview.databinding.ItemCountBinding

class CountAdapter (var context:Context, var veganFoodList:MutableList<FoodM>, var moreBtnLisetner: FoodItemListener): RecyclerView.Adapter<CountAdapter.CountViewHolder>(){

    interface FoodItemListener{
        fun foodItemDelete(foodMore: FoodM)

        fun foodItemUpdate(foodUpdate: FoodM)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountViewHolder {

       return CountViewHolder(ItemCountBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun getItemCount(): Int {
       return veganFoodList.size
    }

    override fun onBindViewHolder(holder: CountViewHolder, position: Int) {

        veganFoodList[position].let {


            holder.binding.apply {

                foodNameTv.text=it.name
                foodDescriptionTv.text=it.description
                yieldsResult.text=it.Yields
                totaltimeResult.text=it.totalTime
                prodcutId.text="Post ID NO: "+it.id
                calServResult.text=it.CalServ

                foodImage.load(it.image)

                  moreBtn.setOnClickListener {_ ->

                          val popupMenu = PopupMenu(context,moreBtn )
                          popupMenu.inflate(R.menu.editandupdate_more_menu)

                          // Set a listener for menu item clicks
                          popupMenu.setOnMenuItemClickListener { menuItem ->

                              when (menuItem.itemId) {
                                  R.id.userEdit -> {

                                      // Handle menu item 1 click
                                      moreBtnLisetner.foodItemUpdate(it)
                                      Toast.makeText(context, "Update ", Toast.LENGTH_LONG).show()


                                  }

                                  R.id.userDelete -> {
                                      moreBtnLisetner.foodItemDelete(it)
                                      // Handle menu item 2 click
                                      Toast.makeText(context, "Delete", Toast.LENGTH_LONG).show()
                                  }


                              }

                              true
                          }

                          // Show the menu
                          popupMenu.show()



                  }

            }


            }


        }

    class CountViewHolder (var binding:ItemCountBinding): RecyclerView.ViewHolder(binding.root)

    }
















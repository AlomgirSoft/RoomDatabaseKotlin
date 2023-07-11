package com.example.kotlin_recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlin_recyclerview.RoomDatabase.FoodDatabase
import com.example.kotlin_recyclerview.RoomDatabase.FoodM
import com.example.kotlin_recyclerview.databinding.ActivityFoodDitailesBinding

class FoodDitailesActivity : AppCompatActivity() {
    lateinit var binding: ActivityFoodDitailesBinding
    lateinit var imageUri:String
    lateinit var name:String
    lateinit var description:String

    companion object{
        const val KAY="kay"
        const val Update="Update"
        const val Submit="Submit"
    }
    lateinit var    getFoodItem:FoodM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityFoodDitailesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getFoodItem=FoodM()

        binding.submitBtn.text= Submit

        if (intent.hasExtra(KAY)){


        getFoodItem=intent.getParcelableExtra<FoodM>(KAY)!!

            getFoodItem.let {

                binding.apply {
                    edName.setText(it.name)
                    edDescription.setText(it.description)
                    edImageUri.setText(it.image)
                    binding.submitBtn.text= Update
                }
            }


        }

      binding.submitBtn.setOnClickListener {
          imageUri=binding.edImageUri.text.toString()
          name=binding.edName.text.toString()
          description=binding.edDescription.text.toString()


         val insertData=FoodM(name = name, image = imageUri , description = description,"","","", id = getFoodItem.id)


          if (binding.submitBtn.text.toString()== Submit){
              FoodDatabase.getInstance(this@FoodDitailesActivity).getFoodDao().insertFood(insertData)
          }else{
              FoodDatabase.getInstance(this@FoodDitailesActivity).getFoodDao().updateFood(insertData)
          }





          val  intent=Intent(this@FoodDitailesActivity,MainActivity::class.java)
          Toast.makeText(this,"Submit Done",Toast.LENGTH_LONG).show()
          startActivity(intent)



      }
    }
}
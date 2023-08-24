package com.example.kotlin_recyclerview.ui.activitys

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.example.kotlin_recyclerview.dbServiec.FoodDatabase
import com.example.kotlin_recyclerview.models.FoodM
import com.example.kotlin_recyclerview.databinding.ActivityFoodDitailesBinding
import com.google.android.gms.cast.framework.media.ImagePicker
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodDitailesActivity : AppCompatActivity() {
    lateinit var binding: ActivityFoodDitailesBinding
    lateinit var imageUri:String
    lateinit var name:String
    lateinit var description:String
    lateinit var uri: String


    private val viewModel:FoodInputViewModel by viewModels()

    companion object{
        const val KAY="kay"
        const val Update="Update"
        const val Submit="Submit"
    }
   private lateinit var    getFoodItem: FoodM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityFoodDitailesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getFoodItem= FoodM()

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


        // val insertData=
            val foodIn= FoodM(name = name, image = uri , description = description,"","","", id = getFoodItem.id)
        //  viewModel.insertFood(foodIn)


          if (binding.submitBtn.text.toString()== Submit){
             // FoodDatabase.getInstance(this@FoodDitailesActivity).getFoodDao().insertFood(insertData)
              viewModel.insertFood(foodIn)
          }else{
             // FoodDatabase.getInstance(this@FoodDitailesActivity).getFoodDao().updateFood(insertData)
              viewModel.updateFood(foodIn)
          }





          val  intent=Intent(this@FoodDitailesActivity, MainActivity::class.java)
          Toast.makeText(this,"Submit Done",Toast.LENGTH_LONG).show()
          startActivity(intent)



      }





    }
}


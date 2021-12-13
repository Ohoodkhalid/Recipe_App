package com.example.recipeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity3 : AppCompatActivity() {

    lateinit var title :EditText
    lateinit var  author:EditText
    lateinit var  ingredients:EditText
    lateinit var  instructions:EditText
    lateinit var addButton:Button
    lateinit var cancel : Button

    var title1=""
    var  author1=""
    var ingredients1=""
    var instructions1=""




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        title = findViewById(R.id.titleEditT)
        author = findViewById(R.id.authorEditT)
        ingredients = findViewById(R.id.ingredientsEditT)
        instructions = findViewById(R.id.instructionsEditT)
        addButton = findViewById(R.id.add)
        cancel = findViewById(R.id.cancel)

        addButton.setOnClickListener{
            title1 = title.text.toString()
            author1 = author.text.toString()
            ingredients1=ingredients.text.toString()
            instructions1= instructions.text.toString()

            addData()

        }

        cancel.setOnClickListener{
            finish()
        }


    }


    fun addData() {
        val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)
        var Details = Recipes(title1,author1,ingredients1,instructions1)
        apiInterface?.addData(Details)?.enqueue(object : Callback<Recipes> {


            override fun onResponse(call: Call<Recipes>, response: Response<Recipes>) {
                Toast.makeText(this@MainActivity3, "ADDED", Toast.LENGTH_LONG).show()


                val intent = Intent(applicationContext, MainActivity2::class.java)
                startActivity(intent)


            }

            override fun onFailure(call: Call<Recipes>, t: Throwable) {
                Toast.makeText(this@MainActivity3, "ERROR", Toast.LENGTH_LONG).show()
            }
        })
    }
}
package com.example.recipeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity2 : AppCompatActivity() {
    val TAG = "ohood"
    var RecipesDetails = ArrayList<Recipes>()
    lateinit var recView : RecyclerView
    lateinit var addButton : Button
    lateinit var adapter:RecyclerViewAdapter
     var  title = ""
     var  author = ""
     var  ingredients = ""
     var  instructions = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
       recView = findViewById(R.id.recyclerView)
        adapter=RecyclerViewAdapter(RecipesDetails)
        recView.adapter = adapter
        recView.layoutManager = LinearLayoutManager(applicationContext)
        addButton = findViewById(R.id.addButton)

        getData()
        addButton.setOnClickListener{
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)


        }


    }

    fun getData(){
        val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)
        apiInterface?.getDetails()?.enqueue(object : Callback<List<Recipes>>  {

            override fun onResponse(call: Call<List<Recipes>>, response: Response<List<Recipes>>) {
               /// RecipesDetails.add(response.body()!![0])
                Log.d(TAG, "succ: ${RecipesDetails}")

               for(data in response.body()!!){
                    RecipesDetails.add(data)

                }
                adapter.notifyDataSetChanged()

            }





            override fun onFailure(call: Call<List<Recipes>>, t: Throwable) {
                Toast.makeText(this@MainActivity2, "ERROR", Toast.LENGTH_LONG).show()
            }
        })
    }





}
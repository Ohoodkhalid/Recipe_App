package com.example.recipeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        supportActionBar?.hide()

        Handler().postDelayed({

            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        },5000)


    }
}
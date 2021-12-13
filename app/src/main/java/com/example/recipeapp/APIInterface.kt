package com.example.recipeapp

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface APIInterface {
   @POST("/recipes/")
 fun addData(@Body Recipes:Recipes): Call<Recipes>
    @GET("/recipes/")
    fun getDetails(): Call<List<Recipes>>





}
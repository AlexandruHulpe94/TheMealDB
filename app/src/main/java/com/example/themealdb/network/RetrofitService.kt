package com.example.themealdb.network

import com.example.themealdb.model.Meals
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("https://www.themealdb.com/api/json/v1/1/lookup.php?i=")
    fun getMealById(@Query("i") id: String): Call<Meals>

    @GET("https://www.themealdb.com/api/json/v1/1/filter.php?i=")
    fun getMealByIngredient(@Query("i") id: String): Call<Meals>
}
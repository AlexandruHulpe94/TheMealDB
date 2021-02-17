package com.example.themealdb.model

import com.example.themealdb.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsRepositoryImpl(private var retrofitService: RetrofitService) : IMealsRepository {
    override fun getMealById(
        id: String,
        successHandler: (List<Meal>?) -> Unit,
        failureHandler: (Throwable?) -> Unit
    ) {
        run {
            retrofitService.getMealById(id).enqueue(object : Callback<Meals> {
                override fun onResponse(call: Call<Meals>?, response: Response<Meals>?) {
                    response?.body()?.let {
                        successHandler(it.meals)
                    }
                }

                override fun onFailure(call: Call<Meals>?, t: Throwable?) {
                    failureHandler(t)
                }
            })
        }
    }

    override fun getMealByIngredient(
        id: String,
        successHandler: (List<Meal>?) -> Unit,
        failureHandler: (Throwable?) -> Unit
    ) {
        run {
            retrofitService.getMealByIngredient(id).enqueue(object : Callback<Meals> {
                override fun onResponse(call: Call<Meals>?, response: Response<Meals>?) {
                    response?.body()?.let {
                        successHandler(it.meals)
                    }
                }

                override fun onFailure(call: Call<Meals>?, t: Throwable?) {
                    failureHandler(t)
                }
            })
        }
    }
}
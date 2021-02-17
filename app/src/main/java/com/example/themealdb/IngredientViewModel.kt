package com.example.themealdb

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.themealdb.model.IMealsRepository
import com.example.themealdb.model.Meal

class IngredientViewModel(private val application: Application) : ViewModel() {

    private lateinit var iMealsRepository: IMealsRepository
    var mealsByIdResponse: MutableLiveData<List<Meal>> = MutableLiveData()
    var apiError = MutableLiveData<Throwable>()

    fun getMealById(id: String) {
        iMealsRepository = InjectorUtil.getInstance()
        iMealsRepository.getMealById(id, {
            mealsByIdResponse.value = it
        }, {
            apiError.value = it

        })
    }
}
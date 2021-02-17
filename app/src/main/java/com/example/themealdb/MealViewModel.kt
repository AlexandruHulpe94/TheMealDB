package com.example.themealdb

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.themealdb.model.IMealsRepository
import com.example.themealdb.model.Meal

class MealViewModel() : ViewModel() {
    private lateinit var iMealsRepository: IMealsRepository
    var mealsByIngredientResponse: MutableLiveData<List<Meal>> = MutableLiveData()
    var mutableIngredientList = mutableListOf<Meal>()

    var apiError = MutableLiveData<Throwable>()

    fun getMealByIngredient(id: String) {
        iMealsRepository = InjectorUtil.getInstance()
        iMealsRepository.getMealByIngredient(id, {
            mealsByIngredientResponse.value = it
            mutableIngredientList = it!!.toMutableList()
        }, {
            apiError.value = it

        })
    }

    fun getMealSize(): Int {
        mutableIngredientList.let {
            return it.size
        }
        return 0
    }

    fun getMealAt(position: Int): Meal? {
        return if (position < getMealSize()) {
            mutableIngredientList.get(position)
        } else {
            null
        }
    }

    fun removeMealAtPosition(position: Int) {
        mutableIngredientList.removeAt(position)
    }

}
package com.example.themealdb.model

interface IMealsRepository {
    fun getMealById(
        id: String,
        successHandler: (List<Meal>?) -> Unit,
        failureHandler: (Throwable?) -> Unit
    )

    fun getMealByIngredient(
        id: String,
        successHandler: (List<Meal>?) -> Unit,
        failureHandler: (Throwable?) -> Unit
    )
}
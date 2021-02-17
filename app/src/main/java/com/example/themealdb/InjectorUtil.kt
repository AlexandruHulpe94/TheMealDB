package com.example.themealdb

import com.example.themealdb.model.IMealsRepository
import com.example.themealdb.model.MealsRepositoryImpl
import com.example.themealdb.network.RetrofitService
import com.example.themealdb.network.RetrofitUtility

class InjectorUtil {
    companion object {

        private var iMealsRepository: IMealsRepository? = null
        var retrofitService: RetrofitService = RetrofitUtility.getRetrofitService()

        fun getInstance(): IMealsRepository {

            synchronized(IMealsRepository::class.java) {
                if (iMealsRepository == null) {
                    iMealsRepository = MealsRepositoryImpl(retrofitService)
                }
            }

            return iMealsRepository!!
        }
    }
}
package com.app.mealsearch.domain.repository

import com.app.mealsearch.data.model.MealsDTO

interface MealListRepository {

    suspend fun getMealList(name : String) : MealsDTO

}
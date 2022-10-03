package com.app.mealsearch.domain.repository

import com.app.mealsearch.data.model.MealsDTO

interface MealDetailsRepository {

    suspend fun getMealDetails(id : String): MealsDTO

}
package com.app.mealsearch.data.repository

import com.app.mealsearch.data.model.MealsDTO
import com.app.mealsearch.data.remote.MealsAPI
import com.app.mealsearch.domain.repository.MealListRepository

class MealListRepositoryImpl(private val mealsAPI: MealsAPI) : MealListRepository {

    override suspend fun getMealList(name: String): MealsDTO {
        return mealsAPI.getMealList(name)
    }

}
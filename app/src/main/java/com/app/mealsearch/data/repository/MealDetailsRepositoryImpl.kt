package com.app.mealsearch.data.repository

import com.app.mealsearch.data.model.MealsDTO
import com.app.mealsearch.data.remote.MealsAPI
import com.app.mealsearch.domain.repository.MealDetailsRepository

class MealDetailsRepositoryImpl(private val mealsAPI: MealsAPI) : MealDetailsRepository {

    override suspend fun getMealDetails(id: String): MealsDTO {
        return mealsAPI.getMealDetails(id)
    }

}
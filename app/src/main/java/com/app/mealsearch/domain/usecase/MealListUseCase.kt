package com.app.mealsearch.domain.usecase

import com.app.mealsearch.data.model.toDomainMeal
import com.app.mealsearch.domain.model.Meal
import com.app.mealsearch.domain.repository.MealListRepository
import com.app.mealsearch.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MealListUseCase @Inject constructor(private val repository: MealListRepository) {

    operator fun invoke(name: String): Flow<Resource<List<Meal>>> = flow {
        try {
            emit(Resource.Loading())

            val response = repository.getMealList(name)
            val list =
                if (response.meals.isEmpty()) emptyList<Meal>() else response.meals.map { it.toDomainMeal() }

            emit(Resource.Success(list))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown Error!"))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Internet Error"))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown Error!"))
        }
    }

}
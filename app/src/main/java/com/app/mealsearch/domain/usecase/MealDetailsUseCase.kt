package com.app.mealsearch.domain.usecase

import com.app.mealsearch.data.model.toDomainMealDetails
import com.app.mealsearch.domain.model.MealDetails
import com.app.mealsearch.domain.repository.MealDetailsRepository
import com.app.mealsearch.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MealDetailsUseCase @Inject constructor(private val repository: MealDetailsRepository) {

    operator fun invoke(id: String): Flow<Resource<MealDetails>> = flow {

        try {

            emit(Resource.Loading())
            val response = repository.getMealDetails(id).meals?.first()?.toDomainMealDetails()
            response?.let {
                emit(Resource.Success(it))
            }

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown Error!"))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Internet Error"))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown Error!"))
        }

    }

}
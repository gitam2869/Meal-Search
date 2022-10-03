package com.app.mealsearch.data.remote

import com.app.mealsearch.data.model.MealsDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface MealsAPI {

    @GET("/api/json/v1/1/search.php")
    suspend fun getMealList(
        @Query("s") name: String
    ): MealsDTO

    @GET("/api/json/v1/1/lookup.php")
    suspend fun getMealDetails(
        @Query("i") id: String
    ): MealsDTO
}
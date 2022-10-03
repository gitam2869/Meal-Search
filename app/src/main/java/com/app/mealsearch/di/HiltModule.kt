package com.app.mealsearch.di

import com.app.mealsearch.data.remote.MealsAPI
import com.app.mealsearch.data.repository.MealDetailsRepositoryImpl
import com.app.mealsearch.data.repository.MealListRepositoryImpl
import com.app.mealsearch.domain.repository.MealDetailsRepository
import com.app.mealsearch.domain.repository.MealListRepository
import com.app.mealsearch.utils.Keys
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Provides
    @Singleton
    fun provideMealAPI(): MealsAPI {
        return Retrofit
            .Builder()
            .baseUrl(Keys.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(MealsAPI::class.java)
    }


    @Provides
    fun provideMealListRepository(mealsAPI: MealsAPI): MealListRepository {
        return MealListRepositoryImpl(mealsAPI)
    }


    @Provides
    fun provideMealDetailsRepository(mealsAPI: MealsAPI): MealDetailsRepository {
        return MealDetailsRepositoryImpl(mealsAPI)
    }


}
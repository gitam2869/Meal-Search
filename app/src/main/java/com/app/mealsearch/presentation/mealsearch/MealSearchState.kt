package com.app.mealsearch.presentation.mealsearch

import com.app.mealsearch.domain.model.Meal

data class MealSearchState(
    val data: List<Meal>? = null,
    val error: String = "",
    val isLoading: Boolean = false
)

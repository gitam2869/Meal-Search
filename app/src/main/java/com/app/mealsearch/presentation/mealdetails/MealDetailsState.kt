package com.app.mealsearch.presentation.mealdetails

import com.app.mealsearch.domain.model.MealDetails

data class MealDetailsState(
    val data: MealDetails? = null,
    val error: String = "",
    val isLoading: Boolean = false
)

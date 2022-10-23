package com.app.mealsearch.presentation.mealsearch

import com.app.mealsearch.domain.model.Meal

interface IMealSearchCallback {
    fun onCardClick(position: Int, meal: Meal)
    fun onCardLongClick(position: Int, meal: Meal)
}
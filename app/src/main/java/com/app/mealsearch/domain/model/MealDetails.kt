package com.app.mealsearch.domain.model

data class MealDetails(
    val id: String,
    val name: String,
    var image: String,
    var instructions: String,
    val items: List<Item>
)

data class Item(
    val ingredient: String,
    val measure: String
)

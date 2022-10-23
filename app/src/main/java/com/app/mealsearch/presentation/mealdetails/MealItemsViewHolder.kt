package com.app.mealsearch.presentation.mealdetails

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.app.mealsearch.databinding.ItemMealItemsBinding
import com.app.mealsearch.domain.model.Item

class MealItemsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding = ItemMealItemsBinding.bind(itemView)

    fun bind(item: Item) {
        binding.meal = item
    }

}
package com.app.mealsearch.presentation.mealsearch

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.app.mealsearch.databinding.ItemMealBinding
import com.app.mealsearch.domain.model.Meal
import com.app.mealsearch.utils.ViewListener.Companion.setOnSingleClickListener

class MealSearchViewHolder(itemView: View, onCardClick: (Int) -> Unit, onCardLongClick: (Int) -> Unit) :
    RecyclerView.ViewHolder(itemView) {

    private val TAG = "MealSearchViewHolder"
    private val binding = ItemMealBinding.bind(itemView)

    init {
        binding.cvMeal.setOnSingleClickListener {
            onCardClick(adapterPosition)
        }

        binding.cvMeal.setOnLongClickListener {
            onCardLongClick(adapterPosition)
            return@setOnLongClickListener true
        }
    }

    fun bind(meal: Meal) {
        binding.meal = meal
    }
}
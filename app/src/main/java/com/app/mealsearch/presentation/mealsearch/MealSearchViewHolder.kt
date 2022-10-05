package com.app.mealsearch.presentation.mealsearch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.mealsearch.R
import com.app.mealsearch.databinding.ItemMealBinding
import com.app.mealsearch.domain.model.Meal

class MealSearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val TAG = "MealSearchViewHolder"
    private val binding = ItemMealBinding.bind(itemView)

    fun bind(meal: Meal) {
        binding.meal = meal
    }

    companion object {
        fun createViewHolder(parent: ViewGroup): MealSearchViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_meal, parent, false)

            return MealSearchViewHolder(view)
        }
    }
}
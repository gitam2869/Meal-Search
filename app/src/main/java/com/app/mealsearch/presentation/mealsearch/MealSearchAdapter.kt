package com.app.mealsearch.presentation.mealsearch

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.mealsearch.R
import com.app.mealsearch.domain.model.Meal

class MealSearchAdapter(private val iMealSearchCallback: IMealSearchCallback) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TAG = "MealSearchAdapter"

    private val differCallback = object : DiffUtil.ItemCallback<Meal>() {
        override fun areItemsTheSame(oldItem: Meal, newItem: Meal): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Meal, newItem: Meal): Boolean {
            return newItem === oldItem
        }
    }

    private val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_meal, parent, false)
        val onCardClick = { position: Int ->
            iMealSearchCallback.onCardClick(position, differ.currentList[position])
        }

        val onCardLongClick = { position: Int ->
            iMealSearchCallback.onCardLongClick(position, differ.currentList[position])
        }

        return MealSearchViewHolder(view, onCardClick, onCardLongClick)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mealSearchViewHolder = holder as MealSearchViewHolder
        mealSearchViewHolder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<Meal>) {
        differ.submitList(list)
    }

}
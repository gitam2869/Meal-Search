package com.app.mealsearch.presentation.mealdetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.mealsearch.R
import com.app.mealsearch.domain.model.Item

class MealItemsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val differCallback = object : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.ingredient == newItem.ingredient
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem === newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_meal_items, parent, false)
        return MealItemsViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mealItemsViewHolder = holder as MealItemsViewHolder
        mealItemsViewHolder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<Item>) {
        differ.submitList(list)
    }
}
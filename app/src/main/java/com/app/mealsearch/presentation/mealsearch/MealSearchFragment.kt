package com.app.mealsearch.presentation.mealsearch

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.app.mealsearch.R
import com.app.mealsearch.databinding.FragmentMealSearchBinding
import com.app.mealsearch.domain.model.Meal
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MealSearchFragment : Fragment() {

    private val TAG = "MealSearchFragment"

    private var _binding: FragmentMealSearchBinding? = null
    private val binding: FragmentMealSearchBinding
        get() = _binding!!

    private val mealSearchViewModel: MealSearchViewModel by viewModels()
    private lateinit var mealSearchAdapter: MealSearchAdapter
    private var list: MutableList<Meal> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMealSearchBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        defaultSetUp()

        binding.svMeal.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    mealSearchAdapter.submitList(emptyList())
                    mealSearchViewModel.searchMealList(it)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

        mealSearchAdapter = MealSearchAdapter(object : IMealSearchCallback {
            override fun onCardClick(position: Int, meal: Meal) {
                navigateToMealDetails(meal.id)
            }

            override fun onCardLongClick(position: Int, meal: Meal) {
                val newList = mutableListOf<Meal>()
                newList.addAll(list)
                newList.removeAt(position)
                mealSearchAdapter.submitList(newList)
                list = newList
            }
        })

        binding.rvMeal.apply {
            adapter = mealSearchAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
        }

        lifecycleScope.launch {
            mealSearchViewModel.mealSearchList.collect {
                Log.d(TAG, "onViewCreated: mealSearchViewModel " + System.currentTimeMillis())
                if (it.isLoading) {
                    Log.d(TAG, "onViewCreated: Loading....")
                    binding.run {
                        pbLoading.visibility = View.VISIBLE
                        tvMessage.visibility = View.GONE
                    }
                }
                if (it.error.isNotBlank()) {
                    Log.d(TAG, "onViewCreated: Error " + it.error)
                    binding.run {
                        pbLoading.visibility = View.GONE
                        tvMessage.text = it.error
                        tvMessage.visibility = View.VISIBLE
                    }
                }

                it.data?.let {
                    Log.d(TAG, "onViewCreated: Suceess " + it)
                    binding.run {

                        if (it.isNotEmpty()) {
                            pbLoading.visibility = View.GONE
                            tvMessage.visibility = View.GONE
                            list = it as MutableList<Meal>
                            mealSearchAdapter.submitList(list)
                        } else {
                            pbLoading.visibility = View.GONE
                            tvMessage.text =
                                requireContext().resources.getString(R.string.not_match)
                            tvMessage.visibility = View.VISIBLE
                        }
                    }
                }
            }
        }
    }

    private fun defaultSetUp() {
        binding.run {
            pbLoading.visibility = View.GONE
            tvMessage.text = requireContext().resources.getString(R.string.search_your_meal)
            tvMessage.visibility = View.VISIBLE
        }
    }

    private fun navigateToMealDetails(mealId: String) {
        findNavController().navigate(
            MealSearchFragmentDirections.actionMealSearchToMealDetails(mealId)
        )
    }
}
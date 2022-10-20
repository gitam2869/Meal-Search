package com.app.mealsearch.presentation.mealdetails

import android.content.res.ColorStateList
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.app.mealsearch.R
import com.app.mealsearch.databinding.FragmentMealDetailsBinding
import com.app.mealsearch.utils.ViewExtension.gone
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MealDetailsFragment : Fragment() {

    private val TAG = "MealDetailsFragment"
    private var _binding: FragmentMealDetailsBinding? = null
    private val binding: FragmentMealDetailsBinding
        get() = _binding!!

    private val args: MealDetailsFragmentArgs by navArgs()

    private val mealDetailsViewModel: MealDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMealDetailsBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        args.mealId?.let {
            mealDetailsViewModel.getMealDetails(it)
        }

        lifecycleScope.launch {
            mealDetailsViewModel.mealDetails.collect{
                Log.d(TAG, "onViewCreated: 1")
                if(it.isLoading){
                    Log.d(TAG, "onViewCreated: 2")
                }

                if(it.error.isNotBlank()){
                    Log.d(TAG, "onViewCreated: 2 "+it.error)
                }

                it.data?.let {
                    Log.d(TAG, "onViewCreated: 3 $it")
                    binding.mealDetails = it
                }
            }
        }


        binding.btnInstructions.setOnClickListener {
            var v = binding.mealDetails
            v?.instructions = "Data binding"
            v?.image = "https://www.themealdb.com/images/media/meals/1529446352.jpg"
            binding.mealDetails = v
        }
    }

    private fun hideItems(){
        binding.run {
            rvItems.gone()
            btnRequiredItems.style
        }
    }

    private fun hideInstructions(){

    }

}
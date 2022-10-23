package com.app.mealsearch.presentation.mealdetails

import android.content.res.ColorStateList
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.paris.extensions.style
import com.app.mealsearch.R
import com.app.mealsearch.databinding.FragmentMealDetailsBinding
import com.app.mealsearch.presentation.MainActivity
import com.app.mealsearch.utils.ViewExtension.gone
import com.app.mealsearch.utils.ViewExtension.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MealDetailsFragment : BaseFragment() {

    private val TAG = "MealDetailsFragment"
    private var _binding: FragmentMealDetailsBinding? = null
    private val binding: FragmentMealDetailsBinding
        get() = _binding!!

    private lateinit var mealItemsAdapter: MealItemsAdapter
    private val args: MealDetailsFragmentArgs by navArgs()
    private var mealName: String? = null

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
        activityMainBinding = (activity as MainActivity).binding

        defaultSetup()

        mealItemsAdapter = MealItemsAdapter()
        binding.rvItems.apply {
            adapter = mealItemsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        args.mealId?.let {
            mealDetailsViewModel.getMealDetails(it)
        }

        lifecycleScope.launch {
            mealDetailsViewModel.mealDetails.collect {
                if (it.isLoading) {
                }
                if (it.error.isNotBlank()) {
                    showErrorView(it.error)
                }
                it.data?.let {
                    mealName = it.name
                    setHeaderTitle(mealName!!)

                    binding.mealDetails = it
                    mealItemsAdapter.submitList(it.items)
                    showDataView()
                }
            }
        }

        binding.btnRequiredItems.setOnClickListener {
            showItemView()
        }

        binding.btnInstructions.setOnClickListener {
            showInstructionView()
        }
    }

    private fun defaultSetup() {
        binding.run {
            cvMeal.gone()
            btnInstructions.gone()
            btnRequiredItems.gone()
            tvMessage.gone()
            pbLoading.visible()
        }
    }


    private fun showDataView(){
        binding.run {
            cvMeal.visible()
            btnInstructions.visible()
            btnRequiredItems.visible()
            tvMessage.gone()
            pbLoading.gone()
        }
        showItemView()
    }

    private fun showErrorView(error: String) {
        binding.run {
            cvMeal.gone()
            btnInstructions.gone()
            btnRequiredItems.gone()
            pbLoading.gone()
            tvMessage.visible()

            tvMessage.text = error
        }
    }

    private fun showItemView() {
        hideInstructions()
        showItems()
    }

    private fun showInstructionView() {
        hideItems()
        showInstructions()
    }

    private fun hideItems() {
        binding.run {
            rvItems.gone()
            btnRequiredItems.style(R.style.PrimaryOutlinedButton)
        }
    }

    private fun hideInstructions() {
        binding.run {
            nsInstructions.gone()
            btnInstructions.style(R.style.PrimaryOutlinedButton)
        }
    }


    private fun showItems() {
        binding.run {
            rvItems.visible()
            btnRequiredItems.style(R.style.PrimaryButton)
        }
    }

    private fun showInstructions() {
        binding.run {
            nsInstructions.visible()
            btnInstructions.style(R.style.PrimaryButton)
        }
    }


    private fun headerLayout(){
        activityMainBinding?.layoutHeader?.header?.run {
            navigationIcon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_back_arrow)
            val title = if(mealName == null)
                requireContext().resources.getString(R.string.app_name)
            else
                mealName

            title?.let { setHeaderTitle(it) }
        }
    }

    private fun setHeaderTitle(title: String){
        activityMainBinding?.layoutHeader?.header?.title = title
    }

    /*************** Life Cycle Events ****************/

    override fun onResume() {
        super.onResume()
        headerLayout()
    }
}
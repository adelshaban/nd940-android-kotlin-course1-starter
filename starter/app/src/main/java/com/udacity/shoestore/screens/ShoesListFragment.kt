package com.udacity.shoestore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionBinding
import com.udacity.shoestore.databinding.FragmentShoesItemBinding
import com.udacity.shoestore.databinding.FragmentShoesListBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodels.ShoesListViewModel

class ShoesListFragment : Fragment() {

    lateinit var shoeListView: LinearLayout
    lateinit var viewModel: ShoesListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        val binding: FragmentShoesListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoes_list, container, false
        )

        shoeListView = binding.shoeListView
        viewModel =
            ViewModelProvider(requireActivity()).get(ShoesListViewModel::class.java)

        loadViewModelItems()

        return binding.root
    }

    private fun loadViewModelItems() {
        for (shoe in viewModel.listOfShoesLiveData.value.orEmpty()){
            addShoeItemToList(shoe)
        }
    }

    fun addShoeItemToList(shoe: Shoe) {
        val itemBinding: FragmentShoesItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_shoes_item,
            shoeListView,
            false
        )

        itemBinding.shoeNameTextView.text = shoe.name
        itemBinding.shoeSizeTextView.text = shoe.size.toString()
        itemBinding.companyTextView.text = shoe.company
        itemBinding.descriptionTextView.text = shoe.description

        shoeListView.addView(itemBinding.root)
    }
}
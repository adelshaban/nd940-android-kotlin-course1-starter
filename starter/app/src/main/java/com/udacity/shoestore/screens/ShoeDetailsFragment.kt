package com.udacity.shoestore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.databinding.FragmentShoesItemBinding
import com.udacity.shoestore.databinding.FragmentShoesListBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodels.ShoesListViewModel

class ShoeDetailsFragment : Fragment() {

    lateinit var binding: FragmentShoeDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_details, container, false)

        binding.cancelButton.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.saveButton.setOnClickListener {
            saveNewShoeItem()
            findNavController().popBackStack()
        }

        return binding.root
    }

    private fun saveNewShoeItem() {
        var viewModel: ShoesListViewModel =
            ViewModelProvider(requireActivity()).get(ShoesListViewModel::class.java)

        val shoe: Shoe = Shoe(
            binding.shoeNameEditText.text.toString(),
            binding.shoeSizeEditText.text.toString().toDouble(),
            binding.companyEditText.text.toString(),
            binding.descriptionEditText.text.toString()
        )

        viewModel.addShoe(shoe)
    }
}
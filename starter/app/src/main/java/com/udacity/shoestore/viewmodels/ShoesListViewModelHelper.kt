package com.udacity.shoestore.viewmodels

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.udacity.shoestore.models.Shoe

class ShoesListViewModelHelper {
    companion object {
        fun generateDummyData(owner: ViewModelStoreOwner, NoOfItems: Int = 5) {
            var viewModel: ShoesListViewModel =
                ViewModelProvider(owner).get(ShoesListViewModel::class.java)
            for (i in 1..NoOfItems) {
                val shoe = generateDummyShoe(i)
                viewModel.addShoe(shoe)
            }
        }

        private fun generateDummyShoe(index: Int): Shoe {
            val shoe: Shoe = Shoe(
                "Shoe$index",
                (10 * index).toDouble(),
                "Company$index",
                "This is shoe#$index"
            )
            return shoe
        }
    }
}
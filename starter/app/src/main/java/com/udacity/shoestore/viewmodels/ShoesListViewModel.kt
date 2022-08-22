package com.udacity.shoestore.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoesListViewModel : ViewModel(){
    private val _listOfShoes : ArrayList<Shoe> = ArrayList<Shoe>()
    private val _listOfShoesLiveData = MutableLiveData<List<Shoe>>()

    public val listOfShoesLiveData : MutableLiveData<List<Shoe>>
            get() = _listOfShoesLiveData

    fun addShoe(shoe: Shoe) {
        _listOfShoes.add(shoe)
        _listOfShoesLiveData.value = _listOfShoes
    }
}
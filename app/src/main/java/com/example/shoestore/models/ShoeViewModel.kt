package com.example.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {
    private var _shoes = MutableLiveData<ArrayList<Shoe>>(ArrayList())
    var shoes: LiveData<ArrayList<Shoe>> = _shoes


    fun add(shoe: Shoe) {
        _shoes.value?.add(shoe)
    }
}
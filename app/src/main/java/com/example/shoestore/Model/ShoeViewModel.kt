package com.example.shoestore.Model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {
    var shoes = MutableLiveData<ArrayList<Shoe>>()

    init {
        shoes.value = ArrayList()
    }


    fun add(shoe: Shoe?) {
        if (shoe == null) {
            shoes.value?.add(shoe)
        }
    }
}

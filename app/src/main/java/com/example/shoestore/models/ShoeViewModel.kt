package com.example.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {
    private var _shoes = MutableLiveData<ArrayList<Shoe>>(ArrayList())
    val shoes: LiveData<ArrayList<Shoe>> get() = _shoes

    var name = MutableLiveData<String>()
    var company = MutableLiveData<String>()
    var size = MutableLiveData<String>()
    var description = MutableLiveData<String>()


    fun add(shoe: Shoe) {
        _shoes.value?.add(shoe)
    }

    fun insert(shoe: ShoeViewModel) {
        add(
            Shoe(
                shoe.name.value ?: "",
                shoe.company.value ?: "",
                shoe.size.value ?: "",
                shoe.description.value ?: ""
            )
        )
    }
}
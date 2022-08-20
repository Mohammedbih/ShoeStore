package com.example.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {
    private var _shoes = MutableLiveData<ArrayList<Shoe>>(ArrayList())
    var shoes: LiveData<ArrayList<Shoe>> = _shoes

    var name = MutableLiveData<String>()
    var company = MutableLiveData<String>()
    var size = MutableLiveData<String>()
    var description = MutableLiveData<String>()


    fun add(shoe: Shoe) {
        _shoes.value?.add(shoe)
    }
    fun insert(){
        add(Shoe(
            name.value?:"",
            company.value?:"",
            size.value?:"",
            description.value?:""
        ))
    }
}
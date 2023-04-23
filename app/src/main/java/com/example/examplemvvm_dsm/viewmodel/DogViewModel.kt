package com.example.examplemvvm_dsm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.examplemvvm_dsm.model.DogModel

class DogViewModel : ViewModel() {

    val dogModel = MutableLiveData<DogModel>()

    fun randomDog(){
        val currentDog = DogModel("https://images.dog.ceo/breeds/borzoi/n02090622_5890.jpg","success")
        dogModel.postValue(currentDog)
    }

}
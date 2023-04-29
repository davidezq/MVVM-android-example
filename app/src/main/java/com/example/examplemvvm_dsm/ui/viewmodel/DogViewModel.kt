package com.example.examplemvvm_dsm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examplemvvm_dsm.data.model.DogModel
import com.example.examplemvvm_dsm.domain.GetDogUseCase
import com.example.examplemvvm_dsm.domain.GetRandomDogUseCase
import kotlinx.coroutines.launch

class DogViewModel : ViewModel() {

    val dogModel = MutableLiveData<DogModel>()
    var progressBarVisibility = MutableLiveData<Boolean>(false)
    var spinLoading = MutableLiveData<Boolean>(false)

    var getDogUseCase = GetDogUseCase()
    var getRandomDogUseCase = GetRandomDogUseCase()
    fun onCreate() {
        viewModelScope.launch {
            progressBarVisibility.postValue(true)
            val result = getDogUseCase()
            dogModel.postValue(result)
            progressBarVisibility.postValue(false)
        }
    }
    fun randomDog() {
        viewModelScope.launch {
            spinLoading.postValue(true)
            val newDog = getRandomDogUseCase()
            dogModel.postValue(newDog)
            spinLoading.postValue(false)
        }
    }


}
package com.example.examplemvvm_dsm.domain

import com.example.examplemvvm_dsm.data.model.DogModel
import com.example.examplemvvm_dsm.data.network.DogService

class GetRandomDogUseCase {
    private val service = DogService()

    suspend operator fun invoke(): DogModel{
        return service.getDog()
    }
}
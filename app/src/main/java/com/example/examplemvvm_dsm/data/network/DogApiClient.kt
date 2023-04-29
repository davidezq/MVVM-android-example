package com.example.examplemvvm_dsm.data.network

import com.example.examplemvvm_dsm.data.model.DogModel
import retrofit2.Response
import retrofit2.http.GET

interface DogApiClient {
    @GET("random")
    suspend fun getRandomDog():Response<DogModel>

}
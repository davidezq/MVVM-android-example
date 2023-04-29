package com.example.examplemvvm_dsm.data.network

import com.example.examplemvvm_dsm.core.RetrofitHelper
import com.example.examplemvvm_dsm.data.model.DogModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.create

class DogService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getDog() : DogModel {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(DogApiClient::class.java).getRandomDog()
            response.body()
                ?: DogModel("https://images.dog.ceo/breeds/borzoi/n02090622_5890.jpg", "success")
        }

    }
}
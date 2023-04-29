package com.example.examplemvvm_dsm.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breeds/image/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
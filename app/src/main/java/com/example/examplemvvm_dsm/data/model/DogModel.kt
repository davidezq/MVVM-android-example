package com.example.examplemvvm_dsm.data.model

import com.google.gson.annotations.SerializedName

data class DogModel(
    @SerializedName("message")
    val image:String,
    val status:String
){
    val breed:String
        get() = image.split("/")[4]
}
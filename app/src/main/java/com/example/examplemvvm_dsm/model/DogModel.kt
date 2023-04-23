package com.example.examplemvvm_dsm.model

data class DogModel(
    val message:String,
    val status:String
){
    val breed:String
        get() = message.split("/")[4]
}
package com.example.examplemvvm_dsm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.examplemvvm_dsm.databinding.ActivityMainBinding
import com.example.examplemvvm_dsm.viewmodel.DogViewModel
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val dogViewModel: DogViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dogViewModel.dogModel.observe(this, Observer { currentDog ->
            Picasso.get().load(currentDog.message).into(binding.ivDogImg)
            binding.tvBreed.text = currentDog.breed
        })

        dogViewModel.randomDog()
    }
}
package com.example.examplemvvm_dsm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.examplemvvm_dsm.databinding.ActivityMainBinding
import com.example.examplemvvm_dsm.ui.viewmodel.DogViewModel
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val dogViewModel: DogViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dogViewModel.onCreate()

        dogViewModel.dogModel.observe(this, Observer { currentDog ->
            Picasso.get().load(currentDog.image).into(binding.ivDogImg)
            binding.tvBreed.text = currentDog.breed
        })

        dogViewModel.progressBarVisibility.observe(this, Observer {
            binding.progressBar.isVisible = it
        })

        dogViewModel.spinLoading.observe(this,Observer{
            binding.swipe.isRefreshing = it
        })

        binding.swipe.setOnRefreshListener {
            dogViewModel.randomDog()
        }
    }
}
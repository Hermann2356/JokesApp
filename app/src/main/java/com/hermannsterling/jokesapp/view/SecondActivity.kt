package com.hermannsterling.jokesapp.view

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.hermannsterling.jokesapp.databinding.ActivitySecondBinding
import com.hermannsterling.jokesapp.viewmodel.MainViewModel
import com.hermannsterling.jokesapp.viewmodel.SecondViewModel

class SecondActivity : AppCompatActivity() {

    private val viewModel by viewModels<SecondViewModel>()
    private lateinit var binding : ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}
package com.hermannsterling.jokesapp.view

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hermannsterling.jokesapp.databinding.ActivityThirdBinding
import com.hermannsterling.jokesapp.model.Joke
import com.hermannsterling.jokesapp.model.JokeResponse
import com.hermannsterling.jokesapp.viewmodel.SecondViewModel
import com.hermannsterling.jokesapp.viewmodel.ThirdViewModel

class ThirdActivity : AppCompatActivity(){

    private val viewModel by viewModels<ThirdViewModel>()
    private lateinit var binding : ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val jokeJson = intent.getStringExtra(SecondActivity.INTENT_STRING)
        val type = object : TypeToken<Joke?>() {}.type
        val joke: Joke = Gson().fromJson(jokeJson, type)

        Log.d("THIRD ACTIVITY", joke.toString())
    }
}
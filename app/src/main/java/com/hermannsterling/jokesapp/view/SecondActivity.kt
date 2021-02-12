package com.hermannsterling.jokesapp.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hermannsterling.jokesapp.adapter.JokeClickListener
import com.hermannsterling.jokesapp.adapter.JokesAdapter
import com.hermannsterling.jokesapp.databinding.ActivitySecondBinding
import com.hermannsterling.jokesapp.model.Joke
import com.hermannsterling.jokesapp.model.JokeResponse
import com.hermannsterling.jokesapp.viewmodel.SecondViewModel

class SecondActivity : AppCompatActivity(), JokeClickListener {

    companion object {
        const val INTENT_STRING = "Intent_String"
    }

    private val viewModel by viewModels<SecondViewModel>()
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val jokeJson = intent.getStringExtra(MainActivity.INTENT_DATA)
        val type = object : TypeToken<JokeResponse?>() {}.type
        val jokes: JokeResponse = Gson().fromJson(jokeJson, type)


        layoutManager = GridLayoutManager(binding.rvJokesList.context, 2)
        binding.rvJokesList.layoutManager = layoutManager

        val jokesAdapter = JokesAdapter(jokes.jokes, this)
        binding.rvJokesList.adapter = jokesAdapter



        setLinearLayout()

        binding.rvJokesList.adapter = jokesAdapter

        binding.smLayout.setOnCheckedChangeListener { _, ischecked ->
            if(ischecked) setLinearLayout() else setGrideLayout()
        }

        Log.d("SECOND ACTIVITY", jokes.jokes.toString())
    }

    fun setLinearLayout(){
        binding.rvJokesList.layoutManager = LinearLayoutManager(binding.rvJokesList.context)
        binding.smLayout.text = "Linear"
        binding.smLayout.isChecked = true
    }

    fun setGrideLayout(){
        binding.rvJokesList.layoutManager = GridLayoutManager(binding.rvJokesList.context, 3)
        binding.smLayout.text = "Grid"
        binding.smLayout.isChecked = false
    }



    override fun itemClicked(joke: Joke) {

        val intent = Intent(this, ThirdActivity::class.java).apply {
            putExtra(INTENT_STRING, Gson().toJson(joke))
        }

        startActivity(intent)
    }
}


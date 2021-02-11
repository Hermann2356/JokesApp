package com.hermannsterling.jokesapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hermannsterling.jokesapp.model.Joke
import com.hermannsterling.jokesapp.model.JokeResponse
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import repo.JokeRepo

class MainViewModel() : ViewModel() {
    companion object {
        private const val TAG = "MainModelView"
    }

    private val _jokes = MutableLiveData<List<Joke>>();

    val jokes : LiveData<List<Joke>>
        get() = _jokes

    fun getJokesByCategories(categories : String, queryMap : Map<String, String>) {
        viewModelScope.launch(Dispatchers.Main) {
            val jokeResponse = JokeRepo.getJokesByCategory(categories, queryMap)
            _jokes.value = jokeResponse.jokes
        }
    }
}
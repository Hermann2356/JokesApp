package com.hermannsterling.jokesapp.adapter

import com.hermannsterling.jokesapp.model.Joke

interface JokeClickListener {
    fun itemClicked(joke : Joke)
}
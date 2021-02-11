package com.hermannsterling.jokesapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.hermannsterling.jokesapp.databinding.ItemJokeBinding
import com.hermannsterling.jokesapp.model.Joke
import kotlin.reflect.KFunction1

class JokesAdapter(@NonNull private val jokes: List<Joke>, private val listener: KFunction1<Joke, Unit>) :
    RecyclerView.Adapter<JokesAdapter.JokeViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): JokeViewHolder {
        val binding = ItemJokeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        );

        return JokeViewHolder(binding, listener)
    }

    override fun onBindViewHolder(
        holder: JokeViewHolder,
        position: Int
    ) {
        val joke = jokes.get(position)
        holder.setJokeText(joke)
        holder.setOnClick(joke)
    }

    override fun getItemCount(): Int {
        return jokes.size
    }

    class JokeViewHolder(@NonNull private val binding: ItemJokeBinding, listener: KFunction1<Joke, Unit>) :
        RecyclerView.ViewHolder(binding.root) {


        fun setJokeText(@NonNull joke: Joke) {
            binding.tvJoke.text = joke.setup
        }

        fun setOnClick(@NonNull joke: Joke) {

        }
    }
}
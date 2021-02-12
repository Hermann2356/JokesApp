package com.hermannsterling.jokesapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.hermannsterling.jokesapp.databinding.ItemJokeBinding
import com.hermannsterling.jokesapp.model.Joke
import com.hermannsterling.jokesapp.view.SecondActivity
import kotlin.reflect.KFunction2

class JokesAdapter(@NonNull private val jokes: List<Joke>, private val listener: JokeClickListener) :
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

    class JokeViewHolder(@NonNull private val binding: ItemJokeBinding, private val listener: JokeClickListener) :
        RecyclerView.ViewHolder(binding.root) {


        fun setJokeText(@NonNull joke: Joke) {
            binding.tvJoke.text = joke.setup
        }

        fun setOnClick(@NonNull joke: Joke) {
            binding.tvJoke.setOnClickListener{
                listener.itemClicked(joke)
            }
        }
    }
}
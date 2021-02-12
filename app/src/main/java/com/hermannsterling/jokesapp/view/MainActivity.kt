package com.hermannsterling.jokesapp.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.hermannsterling.jokesapp.databinding.ActivityMainBinding
import com.hermannsterling.jokesapp.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    companion object {
        const val INTENT_DATA = "Intent_Data"
    }

    private val viewModel by viewModels<MainViewModel>()
    private val queryMap = mapOf<String, String>("amount" to "10", "type" to "twopart")
    private val categories = ArrayList<String>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {

        viewModel.jokes.observe(this) {
            val jokeJson = Gson().toJson(it)
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra(INTENT_DATA, jokeJson)
            }
            startActivity(intent)
        }

        binding.chipAny.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                clearCustomCategoryChipView()
                categories.add("Any")
                binding.chipAny.isChecked = true
            } else categories.remove("Any")


        }

        binding.chipProgramming.setOnCheckedChangeListener { _, isChecked ->
            toggleCustomCategory(isChecked, "Programming")
        }

        binding.chipMisc.setOnCheckedChangeListener { _, isChecked ->
            toggleCustomCategory(isChecked, "Misc")
        }

        binding.chipDark.setOnCheckedChangeListener { _, isChecked ->
            toggleCustomCategory(isChecked, "Dark")
        }

        binding.chipPun.setOnCheckedChangeListener { _, isChecked ->
            toggleCustomCategory(isChecked, "Pun")
        }

        binding.chipSpooky.setOnCheckedChangeListener { _, isChecked ->
            toggleCustomCategory(isChecked, "Spooky")
        }

        binding.chipChristmas.setOnCheckedChangeListener { _, isChecked ->
            toggleCustomCategory(isChecked, "Christmas")
        }

        binding.btnLookup.setOnClickListener {
            if (categories.isNotEmpty()) {
                val categoriesString = categories.joinToString("+")
                viewModel.getJokesByCategories(categoriesString, queryMap)
            }

        }
    }

    private fun toggleCustomCategory(isChecked: Boolean, category: String) {
        if (binding.chipAny.isChecked) {
            binding.chipAny.isChecked = false
            categories.clear()
        }

        if (isChecked) categories.add(category) else categories.remove(category)
    }

    private fun clearCustomCategoryChipView() {
        binding.chipProgramming.isChecked = false
        binding.chipMisc.isChecked = false
        binding.chipDark.isChecked = false
        binding.chipSpooky.isChecked = false
        binding.chipPun.isChecked = false
        binding.chipChristmas.isChecked = false
        categories.clear()
    }
}
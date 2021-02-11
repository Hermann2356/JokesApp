package com.hermannsterling.jokesapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.google.android.material.chip.Chip
import com.hermannsterling.jokesapp.R
import com.hermannsterling.jokesapp.databinding.ActivityMainBinding
import com.hermannsterling.jokesapp.viewmodel.MainViewModel
import java.util.HashMap

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()
    private val queryMap = mapOf<String, String>("amount" to "10", "type" to "twopart")
    private val categories = ArrayList<String>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        viewModel.getJokesByCategories("Programming", queryMap)

        initView()
    }

    private fun initView() {

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
                Log.d("MAIN ACTIVITY", categoriesString)
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
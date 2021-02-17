package com.example.themealdb.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.themealdb.MealViewAdapter
import com.example.themealdb.MealViewModel
import com.example.themealdb.R
import com.example.themealdb.model.Meal

class MainActivity : AppCompatActivity() {
    companion object {
        var viewModel = MealViewModel()
    }

    lateinit var mealViewAdapter: MealViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mealViewAdapter = MealViewAdapter(viewModel)
        val buttonCauta = findViewById<Button>(R.id.cauta)
        val ingredient = findViewById<EditText>(R.id.ingredient)
        buttonCauta.setOnClickListener { viewModel.getMealByIngredient(ingredient.text.toString()) }

        val recyclerView = findViewById<RecyclerView>(R.id.listaRezultate)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = mealViewAdapter
        viewModel.mealsByIngredientResponse.observe(this, Observer<List<Meal>> {
            it?.let { mealViewAdapter.notifyDataSetChanged() }
        })
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        val mealPosition = intent?.getStringExtra("mealPosition")
        if (mealPosition != null) {
            viewModel.removeMealAtPosition(mealPosition.toInt())
            mealViewAdapter.notifyDataSetChanged()
        }
    }

    override fun onResume() {
        super.onResume()
        val mealPosition = intent.getIntExtra("mealPosition", -1)
        if (mealPosition != -1) {
            viewModel.removeMealAtPosition(mealPosition)
            viewModel.mealsByIngredientResponse.observe(this, Observer<List<Meal>> {
                it?.let { mealViewAdapter.notifyDataSetChanged() }
            })
        }
    }
}
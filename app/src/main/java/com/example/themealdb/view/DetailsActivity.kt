package com.example.themealdb.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.themealdb.IngredientViewModel
import com.example.themealdb.R
import com.squareup.picasso.Picasso

class DetailsActivity : AppCompatActivity() {
    lateinit var deleteButton: Button
    lateinit var toolbar: Toolbar
    lateinit var mealName: TextView
    lateinit var mealCategory: TextView
    lateinit var mealArea: TextView
    lateinit var mealThumb: ImageView

    lateinit var ingredient1: TextView
    lateinit var ingredient2: TextView
    lateinit var ingredient3: TextView
    lateinit var ingredient4: TextView
    lateinit var ingredient5: TextView
    lateinit var ingredient6: TextView
    lateinit var measure1: TextView
    lateinit var measure2: TextView
    lateinit var measure3: TextView
    lateinit var measure4: TextView
    lateinit var measure5: TextView
    lateinit var measure6: TextView

    lateinit var instructions: TextView
    lateinit var sourceUrl: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.meal_details_activity)
        initializeViews()
        val mealId = intent.getStringExtra("mealId")
        val mealPosition = intent.getIntExtra("mealPosition", -1)
        deleteButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("mealPosition", mealPosition)
            startActivity(intent)
            this.finish()
        }
        val viewModel = IngredientViewModel(application)
        viewModel.getMealById(mealId)
        viewModel.mealsByIdResponse.observe(this) {
            val meal = it[0]
            Picasso.get().load(meal.getStrMealThumb()).into(mealThumb)
            mealName.text = meal.getStrMeal()
            mealCategory.text = meal.getStrCategory()
            mealArea.text = meal.getStrArea()
            ingredient1.text = meal.getStrIngredient1()
            ingredient2.text = meal.getStrIngredient2()
            ingredient3.text = meal.getStrIngredient3()
            ingredient4.text = meal.getStrIngredient4()
            ingredient5.text = meal.getStrIngredient5()
            ingredient6.text = meal.getStrIngredient6()
            measure1.text = meal.getStrMeasure1()
            measure2.text = meal.getStrMeasure2()
            measure3.text = meal.getStrMeasure3()
            measure4.text = meal.getStrMeasure4()
            measure5.text = meal.getStrMeasure5()
            measure6.text = meal.getStrMeasure6()
            instructions.text = meal.getStrInstructions()
            sourceUrl.text = meal.getStrSource()
        }
    }

    private fun initializeViews() {
        ingredient1 = findViewById(R.id.textViewIngredient1)
        ingredient2 = findViewById(R.id.textViewIngredient2)
        ingredient3 = findViewById(R.id.textViewIngredient3)
        ingredient4 = findViewById(R.id.textViewIngredient4)
        ingredient5 = findViewById(R.id.textViewIngredient5)
        ingredient6 = findViewById(R.id.textViewIngredient6)
        measure1 = findViewById(R.id.textViewMeasure1)
        measure2 = findViewById(R.id.textViewMeasure2)
        measure3 = findViewById(R.id.textViewMeasure3)
        measure4 = findViewById(R.id.textViewMeasure4)
        measure5 = findViewById(R.id.textViewMeasure5)
        measure6 = findViewById(R.id.textViewMeasure6)
        instructions = findViewById(R.id.textViewIns)
        sourceUrl = findViewById(R.id.textViewRandomSourceText)
        mealName = findViewById(R.id.textViewRandomMealName)
        mealCategory = findViewById(R.id.textViewRandomCategory)
        mealArea = findViewById(R.id.textViewRandomMealArea)
        mealThumb = findViewById(R.id.imageViewRandomMealThumb)
        toolbar = findViewById(R.id.toolbar)
        deleteButton = toolbar.findViewById(R.id.toolbarButton)
    }
}
package com.example.themealdb

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.themealdb.model.Meal
import com.example.themealdb.view.DetailsActivity
import com.squareup.picasso.Picasso

class MealViewAdapter(private val viewModel: MealViewModel) :
    RecyclerView.Adapter<MealViewAdapter.MealListViewHolder>() {

    class MealListViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

        var mealName: TextView = view.findViewById(R.id.textViewRandomMealName)
        var mealCategory: TextView = view.findViewById(R.id.textViewRandomCategory)
        var mealArea: TextView = view.findViewById(R.id.textViewRandomMealArea)
        var mealThumb: ImageView = view.findViewById(R.id.imageViewRandomMealThumb)

        var ingredient1: TextView
        var ingredient2: TextView
        var ingredient3: TextView
        var ingredient4: TextView
        var ingredient5: TextView
        var ingredient6: TextView
        var measure1: TextView
        var measure2: TextView
        var measure3: TextView
        var measure4: TextView
        var measure5: TextView
        var measure6: TextView

        var instructions: TextView
        var sourceUrl: TextView

        init {
            ingredient1 = view.findViewById(R.id.textViewIngredient1)
            ingredient2 = view.findViewById(R.id.textViewIngredient2)
            ingredient3 = view.findViewById(R.id.textViewIngredient3)
            ingredient4 = view.findViewById(R.id.textViewIngredient4)
            ingredient5 = view.findViewById(R.id.textViewIngredient5)
            ingredient6 = view.findViewById(R.id.textViewIngredient6)
            measure1 = view.findViewById(R.id.textViewMeasure1)
            measure2 = view.findViewById(R.id.textViewMeasure2)
            measure3 = view.findViewById(R.id.textViewMeasure3)
            measure4 = view.findViewById(R.id.textViewMeasure4)
            measure5 = view.findViewById(R.id.textViewMeasure5)
            measure6 = view.findViewById(R.id.textViewMeasure6)
            instructions = view.findViewById(R.id.textViewIns)
            sourceUrl = view.findViewById(R.id.textViewRandomSourceText)
        }
    }

    override fun onBindViewHolder(holder: MealListViewHolder, position: Int) {
        val meal: Meal = viewModel.getMealAt(position)!!
        Picasso.get().load(meal.getStrMealThumb()).into(holder.mealThumb)
        holder.mealName.text = meal.getStrMeal()
        holder.mealCategory.text = meal.getStrCategory()
        holder.mealArea.text = meal.getStrArea()
        holder.ingredient1.text = meal.getStrIngredient1()
        holder.ingredient2.text = meal.getStrIngredient2()
        holder.ingredient3.text = meal.getStrIngredient3()
        holder.ingredient4.text = meal.getStrIngredient4()
        holder.ingredient5.text = meal.getStrIngredient5()
        holder.ingredient6.text = meal.getStrIngredient6()
        holder.measure1.text = meal.getStrMeasure1()
        holder.measure2.text = meal.getStrMeasure2()
        holder.measure3.text = meal.getStrMeasure3()
        holder.measure4.text = meal.getStrMeasure4()
        holder.measure5.text = meal.getStrMeasure5()
        holder.measure6.text = meal.getStrMeasure6()
        holder.instructions.text = meal.getStrInstructions()
        holder.sourceUrl.text = meal.getStrSource()
        holder.view.tag = position
        holder.view.setOnClickListener { view ->
            val intent = Intent(view.context, DetailsActivity::class.java)
            intent.putExtra("mealId", meal.getIdMeal())
            intent.putExtra("mealPosition", position)
            view.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return viewModel.getMealSize()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealListViewHolder {
        val listView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_meal_view_item, parent, false)
        return MealListViewHolder(listView)
    }
}
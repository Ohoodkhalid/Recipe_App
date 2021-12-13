package com.example.recipeapp

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class RecyclerViewAdapter(var RecipesDetails:List<Recipes>) : RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {

    val TAG = "Adapter"
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent,false))
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val Details = RecipesDetails[position]
      Log.d(TAG, "onBindViewHolder: ${Details.title}")

        holder.itemView.apply {
            tvTitle.text = Details.title
            tvAuthor.text = Details.author
            tvIngredients.text = Details.ingredients
            tvInstructions.text = Details.instructions

        }
    }

    override fun getItemCount() = RecipesDetails.size
}

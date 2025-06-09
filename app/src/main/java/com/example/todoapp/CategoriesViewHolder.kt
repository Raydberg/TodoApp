package com.example.todoapp

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.divider.MaterialDivider

class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvCategoryName: TextView = view.findViewById(R.id.tvCategoryName);
    private val divider: MaterialDivider = view.findViewById(R.id.divider);
    private val viewContainer: CardView = view.findViewById(R.id.viewContainer);

    fun render(taskCategory: TaskCategory, onItemSelected: (Int) -> Unit) {

        val color = if (taskCategory.isSelected) {
            R.color.background_card
        } else {
            R.color.background_disabled
        }

        viewContainer.setCardBackgroundColor(ContextCompat.getColor(tvCategoryName.context, color))

        itemView.setOnClickListener {
            //Ontener la posision de mi elemento o item
            onItemSelected(layoutPosition)
        }

        when (taskCategory) {
            TaskCategory.Business -> {
                tvCategoryName.text = "Negocios"
                divider.setDividerColor(
                    ContextCompat.getColor(
                        divider.context,
                        R.color.business_category
                    )
                )
            }

            TaskCategory.Other -> {
                tvCategoryName.text = "Otros"
                divider.setDividerColor(
                    ContextCompat.getColor(
                        divider.context,
                        R.color.other_category
                    )
                )
            }

            TaskCategory.Personal -> {
                tvCategoryName.text = "Personal"
                divider.setDividerColor(
                    ContextCompat.getColor(
                        divider.context,
                        R.color.personal_category
                    )
                )
            }
        }
    }
}
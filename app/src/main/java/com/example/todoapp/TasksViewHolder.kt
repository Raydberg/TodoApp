package com.example.todoapp

import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class TasksViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvTask: TextView = view.findViewById(R.id.tvTask);
    private val cbTask: CheckBox = view.findViewById(R.id.cbTask);

    fun render(task: Task) {
        if (task.isSelected) {
            //Tachar el texto
            tvTask.paintFlags = tvTask.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            tvTask.paintFlags = tvTask.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
        cbTask.isChecked = task.isSelected
        tvTask.text = task.name
        //Lo mismo que tene el buttonTing o backgroundTint
        /**
         * Ahora para pasarle el contexto no es solo poner -> this
         * Como nosotros estamos en el ViewHolder y estamos accediendo a las vistas ,
         * todas las vistas tienen el contexto de la actividad
         * Asi que nosotros podemos hacer uso del contexto mediante cbTask.context o
         * tvTask.context , da igual por que todos apuntan al mismo contexto
         */
        val color = when (task.category) {
            TaskCategory.Business -> R.color.business_category
            TaskCategory.Other -> R.color.other_category
            TaskCategory.Personal -> R.color.personal_category
        }
        cbTask.buttonTintList = ColorStateList.valueOf(
            ContextCompat.getColor(cbTask.context, color)
        )
    }

}
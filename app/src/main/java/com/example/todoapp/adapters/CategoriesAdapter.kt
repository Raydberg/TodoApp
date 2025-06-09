package com.example.todoapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.CategoriesViewHolder
import com.example.todoapp.TaskCategory
import com.example.todoapp.R

class CategoriesAdapter(private val categories: List<TaskCategory>) :
    RecyclerView.Adapter<CategoriesViewHolder>() {

    // Crea nuevas "cajas"(ViewHolder) para mostrar cada categoria
    // Se llama cada vez que el RecycleView necesita mostrar un elemento
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoriesViewHolder {
        //Creando inflador de vista pasandole el contexto , para luego pasarselo al ViewHolder
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_task_category, parent, false)
        return CategoriesViewHolder(view)
    }

    // Coloca los datos de una categoria especifica en la "caja"
    // Se llama cuando un elemento debe mostrarse en pantalla
    override fun onBindViewHolder(
        holder: CategoriesViewHolder,
        position: Int
    ) {
        //Seria como llamar a cada uno de los items
        holder.render(categories[position])
    }

    // Informa cuantas categorias hay en total
    override fun getItemCount() = categories.size
}
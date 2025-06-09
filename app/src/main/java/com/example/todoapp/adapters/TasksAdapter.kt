package com.example.todoapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.Task
import com.example.todoapp.TasksViewHolder
import com.example.todoapp.R

// Funcion lambda que va a devolver un Int -> private val onTaskSelected: (Int) -> Unit
class TasksAdapter(var tasks: List<Task>, private val onTaskSelected: (Int) -> Unit) :
    RecyclerView.Adapter<TasksViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TasksViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_todo_task, parent, false)
        return TasksViewHolder(view);

    }

    override fun onBindViewHolder(
        holder: TasksViewHolder,
        position: Int
    ) {
        holder.render(tasks[position])
        //Item view es toda la celda el contenido
        holder.itemView.setOnClickListener {
            onTaskSelected(position)
        }
    }

    override fun getItemCount() = tasks.size
}
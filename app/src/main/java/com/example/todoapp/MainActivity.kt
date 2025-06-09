package com.example.todoapp

import android.app.Dialog
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.adapters.CategoriesAdapter
import com.example.todoapp.adapters.TasksAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private val categories = listOf<TaskCategory>(
        TaskCategory.Business,
        TaskCategory.Personal,
        TaskCategory.Other
    )
    private val tasks = mutableListOf<Task>(
        Task("Prueba Business", TaskCategory.Business),
        Task("Prueba Personal", TaskCategory.Personal),
        Task("Prueba Other", TaskCategory.Other)
    )
    private lateinit var rvCategories: RecyclerView;
    private lateinit var rvTasks: RecyclerView;

    //adapter
    private lateinit var categoriesAdapter: CategoriesAdapter;
    private lateinit var taskAdapter: TasksAdapter;

    private lateinit var fabAddTask: FloatingActionButton;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        initComponents()
        initUI()
        initListeners()
    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories)
        //Se encarga de poderle indicar si es scroll vertical u horizontal
        rvCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter;


        taskAdapter = TasksAdapter(tasks)
        //Por defecto ya es vertical asi que solo ponemos this
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = taskAdapter


    }

    private fun initComponents() {
        rvCategories = findViewById(R.id.rvCategories)
        rvTasks = findViewById(R.id.tvTasks)
        fabAddTask = findViewById(R.id.fabAddTask)
    }

    private fun initListeners() {
        fabAddTask.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        //Dialogo
        val dialog = Dialog(this)
    }
}
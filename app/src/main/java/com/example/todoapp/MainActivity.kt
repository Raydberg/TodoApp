package com.example.todoapp

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
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


        taskAdapter = TasksAdapter(tasks,)
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
        //Ponerle nuestro diseño
        dialog.setContentView(R.layout.dialog_task)
        //Encontrar los elementos dentro del dialog
        val btnAddTask: Button = dialog.findViewById(R.id.btnAddTask)
        val etTask: EditText = dialog.findViewById(R.id.etTask)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAddTask.setOnClickListener {
            val currenttask = etTask.text.toString()
            if (currenttask.isNotEmpty()) {
                //Obtener el Id del boton que tenemos selecionado
                val selectedId = rgCategories.checkedRadioButtonId
                //Acceder al boton selecionado en base al id capturado en el RadioGroup
                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedId)
                val currentCategory: TaskCategory =
                    when (selectedRadioButton.text) {
                        "Negocios" -> TaskCategory.Business
                        "Personal" -> TaskCategory.Personal
                        else -> TaskCategory.Other
                    }
                //Añadir la tarea
                tasks.add(Task(currenttask, currentCategory))
                //Avisamos al adaptar que se añadio nuevos items
                updateTask()
                //Cerrar el dialogo
                dialog.hide()
            }
        }

        //Mostrar nuestra vista
        dialog.show()
    }

    //Avisar al adaptador que se añadio un nuevo item
    private fun updateTask() {
        //Esto comprueba uno a uno -> No Optimo
        taskAdapter.notifyDataSetChanged()
    }


    private fun onItemSelected(position: Int) {
        tasks[position].isSelected = !tasks[position].isSelected
        //Notificar cambios
        updateTask()
    }

}
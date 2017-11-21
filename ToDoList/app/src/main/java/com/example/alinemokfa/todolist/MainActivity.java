package com.example.alinemokfa.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper helper = new DatabaseHelper(this);

        Task task1 = new Task("DO STUFF", "LOTS");
//        Task task2 = new Task("DO STUFF2", "LOTS2");
        helper.save(task1);
//        helper.save(task2);

        ArrayList<Task> allTasks = helper.getAllTasks();

        Task dbTask = allTasks.get(0);

//        helper.deleteTask(dbTask.getID().toString());

//        helper.deleteAllTasks();


        task1.setTitle("");

        helper.updateTask(task1);

        allTasks = helper.getAllTasks();

        Toast.makeText(this, "Number of tasks: " + allTasks.size(), Toast.LENGTH_LONG).show();
    }


}
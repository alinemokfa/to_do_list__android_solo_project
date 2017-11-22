package com.example.alinemokfa.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper helper = new DatabaseHelper(this);

        ArrayList<Task> tasks = helper.getAllTasks();

        ListViewAdapter listViewAdapter = new ListViewAdapter(this, tasks);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(listViewAdapter);

        Toast.makeText(this, "Number of tasks: " + tasks.size(), Toast.LENGTH_LONG).show();

        }


    }


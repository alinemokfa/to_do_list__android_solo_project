package com.example.alinemokfa.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //because onCreate is only run once
        // onResume gets called every time the activity gets loaded, so  we don't need this code:

//        ListView listView = findViewById(R.id.list);
//
//        DatabaseHelper helper = new DatabaseHelper(this);
//
//        ArrayList<Task> tasks = helper.getAllTasks();
//
//        ListViewAdapter listViewAdapter = new ListViewAdapter(this, tasks);
//
//        listView.setAdapter(listViewAdapter);
//
//        Toast.makeText(this, "Number of tasks: " + tasks.size(), Toast.LENGTH_LONG).show();

        }

    @Override //after using finish(), refresh adapter
    public void onResume(){
        super.onResume();

        DatabaseHelper helper = new DatabaseHelper(this);

        ListView listView = findViewById(R.id.list);

        ArrayList<Task> tasks = helper.getAllTasks();

        ListViewAdapter listViewAdapter = new ListViewAdapter(this, tasks);

        listView.setAdapter(listViewAdapter);

        Toast.makeText(this, "Number of tasks: " + tasks.size(), Toast.LENGTH_LONG).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.main_menu_home){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.main_menu_add) {
            Intent intent = new Intent(this, AddTaskActivity.class);
            startActivity(intent);
        }
        return true;
    }

    public void getTask(View listItemSelected){

//from where, to where
        Intent intent = new Intent(this, ViewTaskActivity.class);
//defining task and sets = to the specific item/task
        Task selectedTask = (Task) listItemSelected.getTag();
//naming
        intent.putExtra("taskId", selectedTask.getID());

        startActivity(intent);

        Toast.makeText(this, selectedTask.getTitle(), Toast.LENGTH_SHORT).show();
    }

    public void onCheckedBox(View view){

        DatabaseHelper helper = new DatabaseHelper(this);

        Task selectedTask = (Task) view.getTag();

        selectedTask.setCompletion();

        //communicate to db

        helper.updateTask(selectedTask);



    }
}


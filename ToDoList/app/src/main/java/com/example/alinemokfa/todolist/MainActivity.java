package com.example.alinemokfa.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
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
//        } else if (item.getItemId() == R.id.action_???) {
//            Intent intent = new Intent(this, ???Activity.class);
//            startActivity(intent);
        }
        return true;
    }

    public void getTask(View listItemSelected){
        Task selectedTask = (Task) listItemSelected.getTag();

        Toast.makeText(this, selectedTask.getTitle(), Toast.LENGTH_SHORT).show();
    }


    }


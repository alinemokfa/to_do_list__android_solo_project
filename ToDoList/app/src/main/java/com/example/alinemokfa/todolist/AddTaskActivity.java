package com.example.alinemokfa.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
    }

    public void onAddTask(View view) {
        EditText add_task_title = findViewById(R.id.add_task_title);
        EditText add_task_description = findViewById(R.id.add_task_description);


        DatabaseHelper helper = new DatabaseHelper(this);

        Task task = new Task();
        task.setTitle(add_task_title.getText().toString());
        task.setDescription(add_task_description.getText().toString());
        task.setCompletion(false);
        helper.save(task);

        finish(); //goes back to previous activity
    }

}
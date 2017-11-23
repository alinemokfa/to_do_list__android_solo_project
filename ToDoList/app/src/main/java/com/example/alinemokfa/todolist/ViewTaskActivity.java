package com.example.alinemokfa.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ViewTaskActivity extends AppCompatActivity {

    Task task;
    DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_task);

        Intent intent = getIntent();

        Bundle extras = intent.getExtras();

        EditText taskTitleTextView = findViewById(R.id.view_task_title);

        EditText taskDescriptionTextView = findViewById(R.id.view_task_description);

        int task_extra = extras.getInt("taskId");

        helper = new DatabaseHelper(this);

        task = helper.getTaskByID(task_extra);

        taskTitleTextView.setText(task.getTitle());
        taskDescriptionTextView.setText(task.getDescription());
    }
    //create event
    public void onDeleteClick(View view){
        //hook up method to button before writting method

        helper.deleteTask(task.getID().toString());

        finish();
        //the above method instead the below intent
        // Intent intent = new Intent(this, MainActivity.class);
        // startActivity(intent);

    }

    public void onUpdateClick(View listItemSelected){

        EditText viewTaskTitle = findViewById(R.id.view_task_title);
        EditText viewTaskDescription = findViewById(R.id.view_task_description);

        Intent intent = getIntent();

        Bundle extras = intent.getExtras();

        int task_extra = extras.getInt("taskId");

        Task task = helper.getTaskByID(task_extra);

        task.setTitle(viewTaskTitle.getText().toString());
        task.setDescription(viewTaskDescription.getText().toString());

        helper.updateTask(task);

        finish();
    }

}
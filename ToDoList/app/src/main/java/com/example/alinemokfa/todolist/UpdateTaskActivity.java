package com.example.alinemokfa.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UpdateTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_task);
    }

    public void onUpdateTask(View view) {

//        EditText add_task_title = findViewById(R.id.add_task_title);
//        EditText add_task_description = findViewById(R.id.add_task_description);
//
//
//        DatabaseHelper helper = new DatabaseHelper(this);
//
//        Task task = new Task();
//        task.setTitle(add_task_title.getText().toString());
//        task.setDescription(add_task_description.getText().toString());
//        task.setCompletion(false);
//        helper.save(task);
//
//        finish(); //goes back to previous activity
    }
}

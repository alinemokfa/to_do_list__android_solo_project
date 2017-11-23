package com.example.alinemokfa.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by alinemokfa on 21/11/2017.
 */

public class ListViewAdapter extends ArrayAdapter<Task> {

    public ListViewAdapter(Context context, ArrayList<Task> tasks){
        super (context, 0, tasks);
    }


    public View getView(int position, View listItemView, ViewGroup parent) {
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.tasks_item, parent, false);
        }

        Task currentTaskItem = getItem(position);


        TextView title = listItemView.findViewById(R.id.title);
        title.setText(currentTaskItem.getTitle());

//        TextView year = listItemView.findViewById(R.id.description);
//        year.setText(currentTaskItem.getDescription());

        CheckBox checkBox = listItemView.findViewById(R.id.checkBox);
        checkBox.setChecked(currentTaskItem.getCompletion());

        listItemView.setTag(currentTaskItem);
        checkBox.setTag(currentTaskItem);


        return listItemView;
    }

}

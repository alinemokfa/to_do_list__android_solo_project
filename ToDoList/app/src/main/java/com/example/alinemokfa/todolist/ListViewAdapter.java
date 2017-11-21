package com.example.alinemokfa.todolist;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by alinemokfa on 21/11/2017.
 */

public class ListViewAdapter extends ArrayAdapter<Task> {

    public ListViewAdapter(Context context, ArrayList<Task> tasks){
        super (context, 0, tasks);
    }





}

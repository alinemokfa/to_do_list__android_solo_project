package com.example.alinemokfa.todolist;

/**
 * Created by alinemokfa on 21/11/2017.
 */

public class Task {

    private int id;
    private String title;
    private String description;
    private boolean completion;

    public Task() {
    }

    public Task(int id, String title, String description, boolean completion)
    {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completion = completion;

    }

    public Task(String title, String description){
        this.title = title;
        this.description = description;
        this.completion = false;
    }

    public Integer getID(){
        return id;
    }

    public String getTitle() {
        return title;
    }


    public String getDescription() {
        return description;
    }

    public boolean getCompletion() {
        return completion;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompletion(Boolean completion){
        this.completion = completion;
    }
}

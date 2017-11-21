package com.example.alinemokfa.todolist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by alinemokfa on 21/11/2017.
 */

public class TaskTest {

    Task task;

    @Before
    public void before(){
        task = new Task("PDA", "Complete I.T 7");
    }

    @Test
    public void getTitleTest(){
        assertEquals("PDA", task.getTitle());
    }

    @Test
    public void getDescriptionTest(){
        assertEquals("Complete I.T 7", task.getDescription());
    }


}

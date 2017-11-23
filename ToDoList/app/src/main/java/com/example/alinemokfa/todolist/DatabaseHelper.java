package com.example.alinemokfa.todolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.RowId;
import java.util.ArrayList;

/**
 * Created by alinemokfa on 20/11/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "todolist.db";
    public static final String TABLE_NAME = "todo_table";
    public static final int DATABASE_VERSION = 1;
    public static final String COL_ID = "ID";
    public static final String COL_TITLE = "TITLE";
    public static final String COL_DESCRIPTION = "DESCRIPTION";
    public static final String COL_COMPLETION = "COMPLETION";

    //when this constructor is called db will be created
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " ( " + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_TITLE + " VARCHAR, " + COL_DESCRIPTION + " VARCHAR, " + COL_COMPLETION + " BOOLEAN);");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public boolean save(Task task) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_TITLE, task.getTitle());
        contentValues.put(COL_DESCRIPTION, task.getDescription());
        contentValues.put(COL_COMPLETION, task.getCompletion());

        //1 true / 0false
        long result = db.insert(TABLE_NAME, null, contentValues);

        return result != -1; //-1 is eq. to error


    }

    public ArrayList<Task> getAllTasks() {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        ArrayList<Task> tasks = new ArrayList<>();
        Task task;
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();

                int id = cursor.getInt(0);
                String title = cursor.getString(1);
                String description = cursor.getString(2);
                int completed = cursor.getInt(3);
                boolean completedBoolean = (completed == 1);


                task = new Task(id, title, description, completedBoolean);
                tasks.add(task);
            }
        }
        cursor.close();
        database.close();
        return tasks;
    }

    public boolean updateTask(Task task) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_ID, task.getID());
        contentValues.put(COL_TITLE, task.getTitle());
        contentValues.put(COL_DESCRIPTION, task.getDescription());
        contentValues.put(COL_COMPLETION, Boolean.toString(task.getCompletion()));
        int val = db.update(TABLE_NAME, contentValues, "id = " + task.getID(), null);
        return val != -1;
    }


    public void deleteTask(String ID) {
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(TABLE_NAME, COL_ID + " = ?", new String[]{ID});
        database.close();
    }

    public void deleteAllTasks() {
        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL("DELETE FROM " + TABLE_NAME);
        database.close();
    }

    public Task getTaskByID(int id) {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE ID = " + id, null );
        cursor.moveToNext();

        Task task = new Task();
        task.setId(cursor.getInt(0));
        task.setTitle(cursor.getString(1));
        task.setDescription(cursor.getString(2));
        task.setCompletion(cursor.getInt(3) > 0);

        cursor.close();
        database.close();
        return task;
    }

}

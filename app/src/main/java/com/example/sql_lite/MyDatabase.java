package com.example.sql_lite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "studentsdatabase";
    private static final String TABLE_NAME = "students";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String SEX = "sex";
    private static final String CLASS = "class";
    private static final String MATH = "math";
    private static final String PHYSIC = "physic";
    private static final String CHEMISTRY = "chemistry";
    private static final int VERSION = 4;
    private Context context;


    public MyDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQLQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NAME + " TEXT, " +
                SEX + " TEXT, " +
                CLASS + " TEXT, " +
                MATH + " TEXT, " +
                PHYSIC + " TEXT, " +
                CHEMISTRY + " TEXT)";
        sqLiteDatabase.execSQL(SQLQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public void addStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, student.getName());
        values.put(SEX, student.getSex());
        values.put(CLASS, student.getiClass());
        values.put(MATH, student.getPointMath());
        values.put(PHYSIC, student.getPointPhysic());
        values.put(CHEMISTRY, student.getPointChemistry());

        long id = db.insert(TABLE_NAME,null,values);
        Log.e("TAG", "success id = " + id );
        db.close();
    }

    public List<Student> getAllStudent() {
        List<Student> studentList = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Student student = new Student();
                student.setIdStudent(cursor.getString(0));
                student.setName(cursor.getString(1));
                student.setSex(cursor.getString(2));
                student.setiClass(cursor.getString(3));
                student.setPointMath(cursor.getString(4));
                student.setPointPhysic(cursor.getString(5));
                student.setPointChemistry(cursor.getString(6));

                studentList.add(student);
            } while (cursor.moveToNext());

        }
        db.close();
        return studentList;
    }
}

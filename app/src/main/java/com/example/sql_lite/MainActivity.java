package com.example.sql_lite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText edtId,edtName,edtSex,edtIclass,edtMath,edtChemistry,edtPhysic;
    private Button btn;
    private RecyclerView recyclerView;
    private List<Student> studentList;
    private StudentAdapter studentAdapter;

    private MyDatabase myDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDatabase = new MyDatabase(this);
        init();
        loadData();
        btn.setOnClickListener(view -> {
            Student student = createStudent();
            if(student != null){
                myDatabase.addStudent(student);
                loadData();
            }
        });

    }

    private void loadData() {
        studentList = myDatabase.getAllStudent();
        studentAdapter.setList(studentList);
        recyclerView.setAdapter(studentAdapter);
    }

    private Student createStudent() {
        Student student = new Student(edtId.getText().toString(),edtName.getText().toString()
                ,edtSex.getText().toString()
                ,edtIclass.getText().toString()
                ,edtMath.getText().toString()
                ,edtPhysic.getText().toString()
                ,edtChemistry.getText().toString());

        edtId.setText("");
        edtName.setText("");
        edtSex.setText("");
        edtIclass.setText("");
        edtMath.setText("");
        edtPhysic.setText("");
        edtChemistry.setText("");

        return student;
    }

    public void init(){
        edtId = findViewById(R.id.edt_id);
        edtName = findViewById(R.id.edt_name);
        edtSex = findViewById(R.id.edt_sex);
        edtIclass = findViewById(R.id.edt_iclass);
        edtMath = findViewById(R.id.edt_pointmath);
        edtChemistry = findViewById(R.id.edt_pointchemistry);
        edtPhysic = findViewById(R.id.edt_pointphysic);
        btn = findViewById(R.id.btn_add);

        recyclerView = findViewById(R.id.recyclerview);
        studentAdapter  = new StudentAdapter();
        studentList = new ArrayList<>();



    }
}
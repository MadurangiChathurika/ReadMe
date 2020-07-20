package com.industrialmaster.memoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class StudyAddActivity extends AppCompatActivity {

    EditText etName,etDate,etTittle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_add);
        etName = findViewById(R.id.study_name);
        etDate = findViewById(R.id.study_date);
        etTittle = findViewById(R.id.study_tittle);
    }

    public void save (View v){
        String name = etName.getText().toString();
        String date = etDate.getText().toString();
        String tittle = etTittle.getText().toString();
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        String sql = "INSERT INTO study(tittle,name, date, complete) VALUES ('"+tittle+"','"+name+"', '"+date+"', 'false')";
        db.execSQL(sql);

        Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();
    }

    public void back(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

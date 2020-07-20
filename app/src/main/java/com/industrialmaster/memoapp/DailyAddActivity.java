package com.industrialmaster.memoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DailyAddActivity extends AppCompatActivity {

    EditText etName,etTime,etTittle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_add);
        etName = findViewById(R.id.daily_name);
        etTime = findViewById(R.id.daily_time);
        etTittle = findViewById(R.id.daily_tittle);
    }

    public void save (View v){
        String name = etName.getText().toString();
        String time = etTime.getText().toString();
        String tittle = etTittle.getText().toString();
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        String sql = "INSERT INTO daily(tittle,name, time, complete) VALUES ('"+tittle+"','"+name+"', '"+time+"', 'false')";
        db.execSQL(sql);

        Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();
    }

    public void back(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

package com.industrialmaster.memoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ReminderAddActivity extends AppCompatActivity {

    EditText etList,etDate,etName,etTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder_add);
        etList = findViewById(R.id.reminder_list);
        etDate = findViewById(R.id.reminder_date);
        etName = findViewById(R.id.reminder_name);
        etTime = findViewById(R.id.reminder_time);
    }

    public void save (View v){
        String list = etList.getText().toString();
        String date = etDate.getText().toString();
        String time = etTime.getText().toString();
        String name = etName.getText().toString();
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        String sql = "INSERT INTO reminder(date, list, name, time, complete) VALUES ('"+date+"','"+list+"', '"+name+"', '"+time+"', 'false')";
        db.execSQL(sql);

        Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();
    }

    public void back(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

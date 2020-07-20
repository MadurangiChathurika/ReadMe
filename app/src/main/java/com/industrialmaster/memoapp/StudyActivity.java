package com.industrialmaster.memoapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class StudyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudyActivity.this, StudyAddActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        ListView lv = findViewById(R.id.study_list);
        List<String> list = new ArrayList<>();

        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();

        String sql = "SELECT * FROM study WHERE complete = 'false'";
        Cursor cursor = db.rawQuery(sql,null);

        int layout = R.layout.single_study;
        int[] views = {R.id.lbl_study_tittle,R.id.lbl_study_name,R.id.lbl_study_date,R.id.lbl_study_id};
        String[] cols = {"tittle","name","date","_id"};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,layout,cursor,cols,views);
        lv.setAdapter(adapter);
    }

    public void complete(View v){
        LinearLayout layout = (LinearLayout) v.getParent();
        TextView tv = layout.findViewById(R.id.lbl_study_id);

        String id = tv.getText().toString();

        DBHelper myDB = new DBHelper(this);
        SQLiteDatabase db = myDB.getWritableDatabase();

        String sql = "UPDATE study SET complete='true' WHERE _id='"+id+"'";
        db.execSQL(sql);
        Toast.makeText(this,"Note deleted!", Toast.LENGTH_SHORT).show();
        onResume();
    }

    public void back(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}

package com.industrialmaster.memoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TravelledPlacesAddActivity extends AppCompatActivity {

    EditText etCity,etDate,etPlaces;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travelledplaces_add);
        etCity = findViewById(R.id.travelled_city);
        etDate = findViewById(R.id.travelled_date);
        etPlaces = findViewById(R.id.travelled_places);
    }

    public void save (View v){
        String city = etCity.getText().toString();
        String date = etDate.getText().toString();
        String places = etPlaces.getText().toString();
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        String sql = "INSERT INTO travelled(city, date, places, complete) VALUES ('"+city+"','"+date+"', '"+places+"', 'false')";
        db.execSQL(sql);

        Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();
    }

    public void back(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

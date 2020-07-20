package com.industrialmaster.memoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ShoppingAddActivity extends AppCompatActivity {

    EditText etList,etDate,etTotal,etPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_add);
        etList = findViewById(R.id.shopping_list);
        etDate = findViewById(R.id.shopping_date);
        etPrice = findViewById(R.id.shopping_price);
        etTotal = findViewById(R.id.shopping_TotalPrice);
    }

    public void save (View v){
        String list = etList.getText().toString();
        String date = etDate.getText().toString();
        String total = etTotal.getText().toString();
        String price = etPrice.getText().toString();
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        String sql = "INSERT INTO shopping(date, list, price, total, complete) VALUES ('"+date+"','"+list+"', '"+price+"', '"+total+"', 'false')";
        db.execSQL(sql);

        Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();
    }

    public void back(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

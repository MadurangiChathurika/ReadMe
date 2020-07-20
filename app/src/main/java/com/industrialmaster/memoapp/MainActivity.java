package com.industrialmaster.memoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences profile = getSharedPreferences("profile", Context.MODE_PRIVATE);

        TextView tvName = findViewById(R.id.my_name);
        TextView tvEmail = findViewById(R.id.my_email);
        TextView tvMobile = findViewById(R.id.my_mobile);

        String name = profile.getString("name","");
        String email = profile.getString("email","");
        String mobile = profile.getString("mobile","");

        tvName.setText(name);
        tvEmail.setText(email);
        tvMobile.setText(mobile);
    }

    public void study(View v){
        Intent intent = new Intent(this, StudyActivity.class);
        startActivity(intent);
    }

    public void daily(View v){
        Intent intent = new Intent(this, DailyActivity.class);
        startActivity(intent);
    }

    public void idea(View v){
        Intent intent = new Intent(this, IdeaActivity.class);
        startActivity(intent);
    }

    public void profile(View v){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    public void shopping(View v){
        Intent intent = new Intent(this, ShoppingActivity.class);
        startActivity(intent);
    }

    public void reminder(View v){
        Intent intent = new Intent(this, ReminderActivity.class);
        startActivity(intent);
    }

    public void travelled(View v){
        Intent intent = new Intent(this, TravelledPlacesActivity.class);
        startActivity(intent);
    }


}


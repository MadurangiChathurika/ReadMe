package com.industrialmaster.memoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    EditText etName;
    EditText etEmail;
    EditText etMobile;


    SharedPreferences profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        etName = findViewById(R.id.profile_name);
        etEmail = findViewById(R.id.profile_email);
        etMobile = findViewById(R.id.profile_mobile);


    }

    @Override
    protected void onResume() {
        super.onResume();
        profile = getSharedPreferences("profile", Context.MODE_PRIVATE);
        String name = profile.getString("name","");
        String email = profile.getString("email","");
        String mobile = profile.getString("mobile","");


        etName.setText(name);
        etEmail.setText(email);
        etMobile.setText(mobile);

    }

    public void save(View v) {

        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String mobile = etMobile.getText().toString();


        SharedPreferences.Editor profileEditor = profile.edit();
        profileEditor.putString("name", name);
        profileEditor.putString("email", email);
        profileEditor.putString("mobile", mobile);

        profileEditor.commit();

        Toast.makeText(this, "Profile Updated!", Toast.LENGTH_LONG).show();
    }

    public void back(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}


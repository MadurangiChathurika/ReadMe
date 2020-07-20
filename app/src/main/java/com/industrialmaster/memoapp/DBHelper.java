package com.industrialmaster.memoapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context){
        super(context, "dbpapp", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table1 = "CREATE TABLE daily (_id INTEGER PRIMARY KEY AUTOINCREMENT, tittle TEXT, name TEXT, time TEXT, complete BOOLEAN)";
        db.execSQL(table1);

        String table2 = "CREATE TABLE study (_id INTEGER PRIMARY KEY AUTOINCREMENT, tittle TEXT, name TEXT, date TEXT, complete BOOLEAN)";
        db.execSQL(table2);

        String table3 = "CREATE TABLE idea (_id INTEGER PRIMARY KEY AUTOINCREMENT, tittle TEXT, name TEXT, date TEXT, complete BOOLEAN)";
        db.execSQL(table3);

        String table4 = "CREATE TABLE shopping (_id INTEGER PRIMARY KEY AUTOINCREMENT, date TEXT, list TEXT, price TEXT, total TEXT, complete BOOLEAN)";
        db.execSQL(table4);

        String table5 = "CREATE TABLE reminder (_id INTEGER PRIMARY KEY AUTOINCREMENT, date TEXT, list TEXT, name TEXT, time TEXT, complete BOOLEAN)";
        db.execSQL(table5);

        String table6 = "CREATE TABLE travelled (_id INTEGER PRIMARY KEY AUTOINCREMENT, city TEXT, date TEXT, places TEXT, complete BOOLEAN)";
        db.execSQL(table6);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int olderVersion, int newVersion) {
        if(olderVersion==1 && newVersion==2){ //alter query goes here

        }
    }
}

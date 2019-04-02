package com.example.manillenandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public  static  final String DATABASE_NAME = "manillen";
    public  static  final String TABLE_NAME = "instellingen_table";
    private static final int DATABASE_VERSION = 1;
    public  static  final String COL1 = "ID";
    public  static  final String COL2 = "teamNaam1";
    public  static  final String COL3 = "teamNaam2";
    public  static  final String COL4 = "maxScore";

     public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE " + TABLE_NAME + " (" +
                COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 + " TEXT NOT NULL, " +
                COL3 + " TEXT NOT NULL, " +
                COL4 + " INTEGER NOT NULL);"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String teamNaam1, String teamNaam2, int maxScore){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, teamNaam1);
        contentValues.put(COL3, teamNaam2);
        contentValues.put(COL4, maxScore);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1){
            return false;
        }else{
            return true;
        }
    }
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        //int LastRowId = db.rawQuery("SELECT last_insert_rowid() from" + TABLE_NAME,null);
        Cursor res = db.rawQuery("select * from " + TABLE_NAME + "where",null);
        return  res;
    }

}


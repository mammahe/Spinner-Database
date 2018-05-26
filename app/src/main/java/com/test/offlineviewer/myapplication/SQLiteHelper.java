package com.test.offlineviewer.myapplication;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SQLiteHelper extends SQLiteOpenHelper implements DatabaseConstants {
    private Resources resources;
    private SQLiteDatabase database;

    public static final int DB_VERSION = 1;

    public SQLiteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        resources = context.getResources();
        openDatabase();
    }

    public void openDatabase() {
        try {
            this.database = getWritableDatabase();
        } catch (final SQLException se) {
            se.printStackTrace();
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_LANG + "(" + COL_LANG_ID
                + " INTEGER PRIMARY KEY NOT NULL, " + " " + COL_LANG_NAME
                + " VARCHAR(50) NOT NULL);");
        insertLanguage(db, "Sairam PHP");
        insertLanguage(db, "Raju HTML");
        insertLanguage(db, "Gopal Networking");
        insertLanguage(db, "Sai Java");
        insertLanguage(db, "Prasad wordpress");
    }

    private static void insertLanguage(SQLiteDatabase db, String language) {
        db.execSQL("INSERT INTO " + TABLE_LANG + " (" + COL_LANG_NAME
                + ") VALUES ('" + language + "');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public List getdataFromDb() {
        final String sqlQuery = "SELECT " + COL_LANG_ID + ", " + COL_LANG_NAME
                + " FROM " + TABLE_LANG + " ORDER BY "
                + COL_LANG_NAME;

        final Cursor cursor = this.database.rawQuery(sqlQuery, null);

        final List nameList = new ArrayList();

        while (cursor.moveToNext()) {
            nameList.add(cursor.getString(cursor.getColumnIndex(COL_LANG_NAME)));
        }
        cursor.close();
        return nameList;
    }
}

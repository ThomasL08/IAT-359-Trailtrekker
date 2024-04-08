package com.example.trailtrekker;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase {
    private SQLiteDatabase db;
    private Context context;
    private static MyHelper helper;

    public MyDatabase(Context c) {
        context = c;
        helper = new MyHelper(context);
    }

    public void deleteAllData() {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete(Constants.TABLE_NAME, null, null);
    }

    public void updateRow(long rowId, ContentValues contentValues) {
        SQLiteDatabase db = helper.getWritableDatabase();
        String selection = Constants.UID + "=?";
        String[] selectionArgs = {String.valueOf(rowId)};
        db.update(Constants.TABLE_NAME, contentValues, selection, selectionArgs);
    }

    public void insertData(String columnName, String newValue) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(columnName, newValue);
        db.insert(Constants.TABLE_NAME, null, contentValues);
    }

    public void insertUserInfo(String name, double weight, double height) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.NAME, name);
        contentValues.put(Constants.WEIGHT, weight);
        contentValues.put(Constants.HEIGHT, height);
        db.insert(Constants.TABLE_NAME, null, contentValues);
    }

    @SuppressLint("Range")
    public String getTitle(int uid) {
        SQLiteDatabase db = helper.getReadableDatabase();
        String query = "SELECT " + Constants.TITLE + " FROM " + Constants.TABLE_NAME + " WHERE " + Constants.UID + " = ?";
        String[] selectionArgs = {String.valueOf(uid)};
        Cursor cursor = db.rawQuery(query, selectionArgs);
        String result = null;
        if (cursor != null && cursor.moveToFirst()) {
            result = cursor.getString(cursor.getColumnIndex(Constants.TITLE));
            cursor.close();
        }
        return result;
    }

    @SuppressLint("Range")
    public String getName() {
        SQLiteDatabase db = helper.getReadableDatabase();
        String query = "SELECT " + Constants.NAME + " FROM " + Constants.TABLE_NAME + " WHERE " + Constants.UID + " = ?";
        String[] selectionArgs = {"1"};
        Cursor cursor = db.rawQuery(query, selectionArgs);
        String result = null;
        if (cursor != null && cursor.moveToFirst()) {
            result = cursor.getString(cursor.getColumnIndex(Constants.NAME));
            cursor.close();
        }
        return result;
    }

    @SuppressLint("Range")
    public String getCalories(int uid) {
        SQLiteDatabase db = helper.getReadableDatabase();
        String query = "SELECT " + Constants.CALORIES + " FROM " + Constants.TABLE_NAME + " WHERE " + Constants.UID + " = ?";
        String[] selectionArgs = {String.valueOf(uid)};
        Cursor cursor = db.rawQuery(query, selectionArgs);
        String result = null;
        if (cursor != null && cursor.moveToFirst()) {
            result = cursor.getString(cursor.getColumnIndex(Constants.CALORIES));
            cursor.close();
        }
        return result;
    }

    @SuppressLint("Range")
    public String getStepCount(int uid) {
        SQLiteDatabase db = helper.getReadableDatabase();
        String query = "SELECT " + Constants.STEP_COUNT + " FROM " + Constants.TABLE_NAME + " WHERE " + Constants.UID + " = ?";
        String[] selectionArgs = {String.valueOf(uid)};
        Cursor cursor = db.rawQuery(query, selectionArgs);
        String result = null;
        if (cursor != null && cursor.moveToFirst()) {
            result = cursor.getString(cursor.getColumnIndex(Constants.STEP_COUNT));
            cursor.close();
        }
        return result;
    }

    @SuppressLint("Range")
    public String getDistance(int uid) {
        SQLiteDatabase db = helper.getReadableDatabase();
        String query = "SELECT " + Constants.DISTANCE + " FROM " + Constants.TABLE_NAME + " WHERE " + Constants.UID + " = ?";
        String[] selectionArgs = {String.valueOf(uid)};
        Cursor cursor = db.rawQuery(query, selectionArgs);
        String result = null;
        if (cursor != null && cursor.moveToFirst()) {
            result = cursor.getString(cursor.getColumnIndex(Constants.DISTANCE));
            cursor.close();
        }
        return result;
    }

    @SuppressLint("Range")
    public static String getWeight() {
        SQLiteDatabase db = helper.getReadableDatabase();

        String query = "SELECT " + Constants.WEIGHT + " FROM " + Constants.TABLE_NAME +
                " WHERE " + Constants.UID + " = ?";
        String[] selectionArgs = {"1"}; // ID 1
        Cursor cursor = db.rawQuery(query, selectionArgs);

        String result = null;
        if (cursor != null && cursor.moveToFirst()) {
            result = cursor.getString(cursor.getColumnIndex(Constants.WEIGHT));
            cursor.close();
        }
        return result;
    }

    @SuppressLint("Range")
    public String getHeight() {
        SQLiteDatabase db = helper.getReadableDatabase();

        String query = "SELECT " + Constants.HEIGHT + " FROM " + Constants.TABLE_NAME +
                " WHERE " + Constants.UID + " = ?";
        String[] selectionArgs = {"1"}; // ID 1
        Cursor cursor = db.rawQuery(query, selectionArgs);

        String result = null;
        if (cursor != null && cursor.moveToFirst()) {
            result = cursor.getString(cursor.getColumnIndex(Constants.HEIGHT));
            cursor.close();
        }
        return result;
    }

    public int getRowCount() {
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM " + Constants.TABLE_NAME, null);
        int count = 0;
        if (cursor != null) {
            cursor.moveToFirst();
            count = cursor.getInt(0);
            cursor.close();
        }
        return count;
    }

    public void insertHistoryTitle(String columnName, String newValue) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(columnName, newValue);
        db.insert(Constants.LOCATION_TABLE_NAME, null, contentValues);
    }

    public void updateHistoryRow(long rowId, ContentValues contentValues) {
        SQLiteDatabase db = helper.getWritableDatabase();
        String selection = Constants.COLUMN_ID + "=?";
        String[] selectionArgs = {String.valueOf(rowId)};
        db.update(Constants.LOCATION_TABLE_NAME, contentValues, selection, selectionArgs);
    }
    public int getHistoryRowCount() {
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM " + Constants.LOCATION_TABLE_NAME, null);
        int count = 0;
        if (cursor != null) {
            cursor.moveToFirst();
            count = cursor.getInt(0);
            cursor.close();
        }
        return count;
    }


    @SuppressLint("Range")
    public List<HistoryItem> getAllHistoryItems() {
        List<HistoryItem> historyItems = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = null;

        try {
            cursor = db.query(
                    Constants.LOCATION_TABLE_NAME, // Table name
                    new String[]{Constants.COLUMN_LONGITUDE, Constants.COLUMN_LATITUDE, Constants.COLUMN_TITLE}, // Columns to fetch
                    null, // Selection
                    null, // Selection arguments
                    null, // Group by
                    null, // Having
                    null // Order by
            );

            // Loop through the cursor and create HistoryItem objects
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    String longitude = cursor.getString(cursor.getColumnIndex(Constants.COLUMN_LONGITUDE));
                    String latitude = cursor.getString(cursor.getColumnIndex(Constants.COLUMN_LATITUDE));
                    String title = cursor.getString(cursor.getColumnIndex(Constants.COLUMN_TITLE));
                    HistoryItem historyItem = new HistoryItem(title, "Destination: " + latitude + ", " + longitude);
                    historyItems.add(historyItem);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.e("MyDatabase", "Error fetching history items from database: " + e.getMessage());
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }

        return historyItems;
    }
}


package com.hillal.hhhhhhh.db;

import android.content.Context;
import android.util.Log;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Report.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static final String TAG = "AppDatabase";
    private static volatile AppDatabase INSTANCE;

    public abstract ReportDao reportDao();

    public static AppDatabase getDatabase(final Context context) {
        Log.d(TAG, "Getting database instance");
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    try {
                        Log.d(TAG, "Creating new database instance");
                        INSTANCE = Room.databaseBuilder(
                                context.getApplicationContext(),
                                AppDatabase.class,
                                "reports_database"
                        ).build();
                        Log.d(TAG, "Database instance created successfully");
                    } catch (Exception e) {
                        Log.e(TAG, "Error creating database instance", e);
                        throw new RuntimeException("Failed to create database", e);
                    }
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        Log.d(TAG, "Destroying database instance");
        INSTANCE = null;
    }
} 
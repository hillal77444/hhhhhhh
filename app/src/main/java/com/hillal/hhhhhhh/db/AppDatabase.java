package com.hillal.hhhhhhh.db;

import android.content.Context;
import android.util.Log;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Report.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "app_database";
    private static volatile AppDatabase instance;

    public abstract ReportDao reportDao();

    public static synchronized AppDatabase getDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                context.getApplicationContext(),
                AppDatabase.class,
                DATABASE_NAME
            ).build();
        }
        return instance;
    }

    public static void destroyInstance() {
        Log.d("AppDatabase", "Destroying database instance");
        instance = null;
    }
} 
package com.hillal.hhhhhhh;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Account.class, Transaction.class}, version = 1, exportSchema = true)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    private static final String TAG = "AppDatabase";
    private static AppDatabase instance;

    public abstract AccountDao accountDao();
    public abstract TransactionDao transactionDao();

    public static synchronized AppDatabase getInstance(Context context) {
        Log.d(TAG, "Getting database instance");
        if (instance == null) {
            try {
                Log.d(TAG, "Creating new database instance");
                instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class,
                    "app_database"
                ).fallbackToDestructiveMigration()
                 .build();
                Log.d(TAG, "Database instance created successfully");
            } catch (Exception e) {
                Log.e(TAG, "Error creating database instance", e);
                throw e;
            }
        }
        return instance;
    }
} 
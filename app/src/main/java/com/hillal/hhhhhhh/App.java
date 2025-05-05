package com.hillal.hhhhhhh;

import android.app.Application;
import android.util.Log;

public class App extends Application {
    private static final String TAG = "App";
    private static App instance;
    private AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        try {
            instance = this;
            database = AppDatabase.getInstance(this);
        } catch (Exception e) {
            Log.e(TAG, "Error initializing application", e);
        }
    }

    public static App getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Application not initialized");
        }
        return instance;
    }

    public AppDatabase getDatabase() {
        if (database == null) {
            throw new IllegalStateException("Database not initialized");
        }
        return database;
    }
} 
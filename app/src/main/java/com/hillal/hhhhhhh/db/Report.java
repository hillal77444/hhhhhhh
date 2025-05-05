package com.hillal.hhhhhhh.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "reports")
public class Report {
    @PrimaryKey(autoGenerate = true)
    public int id;
    
    public String title;
    public String description;
    public long timestamp;
    
    public Report(String title, String description) {
        this.title = title;
        this.description = description;
        this.timestamp = System.currentTimeMillis();
    }
} 
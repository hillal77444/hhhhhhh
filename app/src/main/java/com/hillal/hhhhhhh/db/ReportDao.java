package com.hillal.hhhhhhh.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface ReportDao {
    @Query("SELECT * FROM reports ORDER BY timestamp DESC")
    List<Report> getAllReports();
    
    @Insert
    void insertReport(Report report);
    
    @Delete
    void deleteReport(Report report);
    
    @Query("DELETE FROM reports")
    void deleteAllReports();
} 
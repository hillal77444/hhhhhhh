package com.hillal.hhhhhhh.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@Dao
public interface ReportDao {
    @Query("SELECT * FROM reports ORDER BY createdAt DESC")
    List<Report> getAllReports();

    @Query("SELECT * FROM reports WHERE id = :id")
    Report getReportById(int id);

    @Insert
    void insertReport(Report report);

    @Update
    void updateReport(Report report);

    @Delete
    void deleteReport(Report report);
} 
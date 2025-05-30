package com.hillal.acc.data.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.hillal.acc.data.model.User;
import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM users")
    List<User> getAllUsers();

    @Query("SELECT * FROM users WHERE id = :userId")
    User getUserById(long userId);

    @Query("SELECT * FROM users WHERE phone = :phone LIMIT 1")
    User getUserByPhone(String phone);

    @Query("SELECT * FROM users LIMIT 1")
    User getCurrentUser();

    @Insert
    long insert(User user);

    @Update
    void update(User user);

    @Query("DELETE FROM users WHERE id = :userId")
    void delete(long userId);

    @Query("SELECT * FROM users WHERE lastSyncTime > :lastSyncTime")
    List<User> getModifiedUsers(long lastSyncTime);
} 
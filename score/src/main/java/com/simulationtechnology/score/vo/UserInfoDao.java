package com.simulationtechnology.score.vo;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserInfoDao {
    @Query("SELECT * FROM user_info")
    List<UserInfo> getAllUserInfo();

    @Query("SELECT * FROM user_info WHERE name = :name LIMIT 1")
    UserInfo getUserInfoByName(String name);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUserInfo(UserInfo info);

    @Query("DELETE FROM user_info WHERE name = :name")
    void deleteUserByName(String name);
}

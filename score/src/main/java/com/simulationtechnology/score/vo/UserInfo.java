package com.simulationtechnology.score.vo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "user_info")
public class UserInfo {
    @PrimaryKey
    @NonNull
    public String userId;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "password")
    public String password;
}

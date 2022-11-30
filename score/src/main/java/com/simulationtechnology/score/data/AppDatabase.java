package com.simulationtechnology.score.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.simulationtechnology.score.vo.UserInfo;
import com.simulationtechnology.score.vo.UserInfoDao;

@Database(entities = {UserInfo.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DB_NAME = "simulation_user.db";

    private static AppDatabase instance;

    public abstract UserInfoDao userInfoDao();

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class, DB_NAME).build();
        }
        return instance;
    }

}

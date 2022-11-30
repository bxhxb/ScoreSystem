package com.simulationtechnology.scoresystem;

import android.app.Application;

import com.simulationtechnology.score.data.AppDatabase;

import java.util.concurrent.Executors;

import io.reactivex.rxjava3.schedulers.Schedulers;

public class ScoreApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Schedulers.io().scheduleDirect(this::initAppDatabase);
    }

    private void initAppDatabase() {
        AppDatabase.getInstance(getApplicationContext());
    }
}

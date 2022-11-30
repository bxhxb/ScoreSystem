package com.simulationtechnology.score.presentation;

import static com.simulationtechnology.score.constant.Global.GLOBAL_TAG;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.simulationtechnology.score.data.ScoreRepository;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainViewModel extends AndroidViewModel {

    public LiveData<String> nameData = new MutableLiveData<>();

    public MainViewModel(@NonNull Application application) {
        super(application);
        ScoreRepository.getInstance().setContext(application.getApplicationContext());
    }

    void toVerifyAccount() {
        ScoreRepository.getInstance().verifyAccount()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<String>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {
                        Log.d(GLOBAL_TAG, "in on subscribe");
                    }

                    @Override
                    public void onSuccess(@io.reactivex.rxjava3.annotations.NonNull String s) {
                        Log.d(GLOBAL_TAG, "in on success, the value is " + s);
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                        Log.d(GLOBAL_TAG, "in on error");
                    }
                });
    }

    void sendHttpRequest() {
        ScoreRepository.getInstance().sendHttpRequest()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<String>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@io.reactivex.rxjava3.annotations.NonNull String s) {

                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {

                    }
                });
    }

    public void databaseOperation() {
        ScoreRepository.getInstance().saveToDatabase()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Boolean>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@io.reactivex.rxjava3.annotations.NonNull Boolean aBoolean) {

                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {

                    }
                });

    }
}

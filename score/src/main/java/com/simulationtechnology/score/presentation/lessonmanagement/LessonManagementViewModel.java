package com.simulationtechnology.score.presentation.lessonmanagement;

import android.app.Application;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.simulationtechnology.score.data.ScoreRepository;
import com.simulationtechnology.score.vo.LessonInfo;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class LessonManagementViewModel extends AndroidViewModel {
    public MutableLiveData<List<LessonInfo>> lessonInfoList = new MutableLiveData<>();

    public LessonManagementViewModel(Application application) {
        super(application);
        this.fetchLessonList();
    }

    public void fetchLessonList() {
        ScoreRepository.getInstance().fetchLessonList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<LessonInfo>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull List<LessonInfo> lessonInfos) {
                        lessonInfoList.postValue(lessonInfos);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });
    }
}

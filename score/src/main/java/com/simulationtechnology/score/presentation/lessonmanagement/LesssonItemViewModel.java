package com.simulationtechnology.score.presentation.lessonmanagement;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LesssonItemViewModel {
    public MutableLiveData<String> lessonName = new MutableLiveData<>();
    public MutableLiveData<String> author = new MutableLiveData<>();
}

package com.simulationtechnology.score.presentation;

import android.view.View;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.simulationtechnology.score.presentation.lessonmanagement.LessonAdapter;
import com.simulationtechnology.score.vo.LessonInfo;

import java.util.List;

public class ListBindingAdapter {

    @BindingAdapter("app:lessonLists")
    public static void setLessonInfoList(RecyclerView recyclerView, List<LessonInfo> lists) {
        if (lists != null && recyclerView.getAdapter() instanceof LessonAdapter) {
            LessonAdapter adapter = (LessonAdapter) recyclerView.getAdapter();
            adapter.setItems(lists);
        }
    }
}

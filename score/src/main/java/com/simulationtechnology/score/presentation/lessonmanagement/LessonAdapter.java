package com.simulationtechnology.score.presentation.lessonmanagement;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.simulationtechnology.score.R;
import com.simulationtechnology.score.databinding.ItemLessonInfoBinding;
import com.simulationtechnology.score.vo.LessonInfo;

import java.util.ArrayList;
import java.util.List;

public class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.LessonInfoViewHolder> {
    final private List<LessonInfo> lessonInfoList = new ArrayList<>();
    private List<OnItemClickListener> itemClickListeners;

    public LessonAdapter() {
        super();
        itemClickListeners = new ArrayList<>();
    }

    public void setItems(List<LessonInfo> lists) {
        if (lists != null) {
            lessonInfoList.clear();
            lessonInfoList.addAll(lists);
            notifyDataSetChanged();
        }
    }

    public void addItemClickListener(OnItemClickListener listener) {
        if (!itemClickListeners.contains(listener)) {
            itemClickListeners.add(listener);
        }
    }

    public void removeClickListener(OnItemClickListener listener) {
        itemClickListeners.remove(listener);
    }

    @Override
    public int getItemCount() {
        return lessonInfoList.size();
    }

    @NonNull
    @Override
    public LessonAdapter.LessonInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemLessonInfoBinding binding = ItemLessonInfoBinding.inflate(inflater, parent, false);
        return new LessonInfoViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull LessonAdapter.LessonInfoViewHolder holder, int position) {
        LessonInfo info = lessonInfoList.get(position);
        LesssonItemViewModel viewModel = holder.binding.getViewmodel();
        if (viewModel == null) {
            viewModel = new LesssonItemViewModel();
        }
        viewModel.lessonName.setValue(info.lessonName);
        viewModel.author.setValue(info.author);

        holder.binding.setViewmodel(viewModel);
        holder.binding.setClickListener(v -> {
            for (OnItemClickListener listener : itemClickListeners) {
                listener.onItemClick(info);
            }
        });
    }

    class LessonInfoViewHolder extends RecyclerView.ViewHolder {
        public ItemLessonInfoBinding binding;
        public LessonInfoViewHolder(ItemLessonInfoBinding infoBinding) {
            super(infoBinding.getRoot());
            binding = infoBinding;
        }
    }

//    static class LessonInfoDifferCallback extends DiffUtil.ItemCallback<LessonInfo> {
//        @Override
//        public boolean areItemsTheSame(@NonNull LessonInfo oldItem, @NonNull LessonInfo newItem) {
//            return oldItem.lessonName.equals(newItem.lessonName);
//        }
//
//        @Override
//        public boolean areContentsTheSame(@NonNull LessonInfo oldItem, @NonNull LessonInfo newItem) {
//            return oldItem.lessonName.equals(newItem.lessonName);
//        }
//    }
}

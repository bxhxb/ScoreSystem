package com.simulationtechnology.score.presentation.lessonmanagement;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.simulationtechnology.score.R;
import com.simulationtechnology.score.databinding.FragmentLessonManagementBinding;
import com.simulationtechnology.score.vo.LessonInfo;

public class LessonManagementFragment extends Fragment {

    private LessonManagementViewModel viewModel;
    private FragmentLessonManagementBinding binding;
    private LessonAdapter adapter;
    private ItemListener itemListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_lesson_management, container, false);
        binding.setLifecycleOwner(this);
        binding.setFragment(this);
        viewModel = new LessonManagementViewModel(getActivity().getApplication());
        binding.setViewmodel(viewModel);
        adapter = new LessonAdapter();
        binding.lessonLists.setAdapter(adapter);

        itemListener = new ItemListener();
        adapter.addItemClickListener(itemListener);

//        String params = getArguments().getString("title");
//        Log.d(GLOBAL_TAG, "The content of title is " + "\"" + params + "\"");
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        adapter.removeClickListener(itemListener);
    }

    public void onBackClicked(View view) {
        Navigation.findNavController(view).popBackStack();
    }

    class ItemListener implements OnItemClickListener {
        @Override
        public void onItemClick(LessonInfo info) {

        }
    }
}

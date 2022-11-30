package com.simulationtechnology.score.presentation;

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
import com.simulationtechnology.score.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {

    private MainViewModel viewModel;
    private FragmentMainBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        binding.setLifecycleOwner(this);
        viewModel = new MainViewModel(getActivity().getApplication());
        binding.setViewmodel(viewModel);
        binding.setFragment(this);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel.nameData.observe(getViewLifecycleOwner(), s -> {

        });
    }

    public void onLessonManagementClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("title", "I am the title");

//        NavOptions navOptions = new NavOptions.Builder()
//                                .setEnterAnim(android.R.anim.slide_in_left)
//                                .setExitAnim(android.R.anim.slide_out_right)
//                                .setPopEnterAnim(android.R.anim.slide_in_left)
//                                .setPopExitAnim(android.R.anim.slide_out_right)
//                                .build();

        Navigation.findNavController(view).navigate(R.id.frag_lesson_management);
        //Navigation.findNavController(view).navigate(R.id.frag_lesson_management, bundle, navOptions);
    }

    public void onOperationClick(View view) {
        Navigation.findNavController(view).navigate(R.id.frag_operation);
    }

    public void onVerifyClick() {
        viewModel.toVerifyAccount();
    }

    public void onHttpRequest() {
        viewModel.sendHttpRequest();
    }

    public void onDatabaseOperation() {
        viewModel.databaseOperation();
    }
}

package com.simulationtechnology.score.presentation.operation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.simulationtechnology.score.R;
import com.simulationtechnology.score.databinding.FragmentOperationBinding;

public class OperationFragment extends Fragment {
    private FragmentOperationBinding binding;
    private OperationViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_operation, container, false);
        return binding.getRoot();
    }
}

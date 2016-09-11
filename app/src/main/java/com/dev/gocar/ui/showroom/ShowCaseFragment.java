package com.dev.gocar.ui.showroom;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.gocar.databinding.FragmentShowcaseBinding;

public class ShowCaseFragment extends Fragment {

    private String title;

    private int backgorund;

    private FragmentShowcaseBinding binding;

    public static ShowCaseFragment newInstance(String title, int resource) {
        ShowCaseFragment showCase = new ShowCaseFragment();
        showCase.title = title;
        showCase.backgorund = resource;
        return showCase;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentShowcaseBinding.inflate(inflater, container, false);

        setView();

        return binding.getRoot();
    }

    private void setView() {

        binding.imageViewBackground.setImageResource(backgorund);

    }

}

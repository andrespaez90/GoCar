package com.dev.gocar.ui.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dev.gocar.ui.model.ShowCaseModel;
import com.dev.gocar.ui.showroom.ShowCaseFragment;

import java.util.ArrayList;

public class ShowRoomAdapter extends FragmentPagerAdapter {

    private ArrayList<ShowCaseModel> showCasesModels;

    public ShowRoomAdapter(FragmentManager fm, ArrayList<ShowCaseModel> showCases) {
        super(fm);
        this.showCasesModels = showCases;
    }

    @Override
    public Fragment getItem(int position) {

        ShowCaseModel showCasePage;

        if (showCasesModels != null && showCasesModels.size() > position) {
            showCasePage = showCasesModels.get(position);
            return ShowCaseFragment.newInstance(showCasePage.getTitle(), showCasePage.getImage());
        }

        return null;
    }

    @Override
    public int getCount() {
        return showCasesModels.size();
    }
}
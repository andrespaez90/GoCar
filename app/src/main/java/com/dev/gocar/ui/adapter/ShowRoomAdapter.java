package com.dev.gocar.ui.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.dev.gocar.R;
import com.dev.gocar.ui.model.ShowCaseModel;
import com.dev.gocar.ui.widgets.showroom.ShowCase;
import com.dev.gocar.ui.widgets.showroom.UsedShowCase;

import java.util.ArrayList;

public class ShowRoomAdapter extends FragmentPagerAdapter {

    private ArrayList<ShowCaseModel> showCasesModels;

    public ShowRoomAdapter(FragmentManager fm, ArrayList<ShowCaseModel> showCases) {
        super(fm);
        this.showCasesModels = showCases;
        //this.showCasesModels.add(new ShowCaseModel("Carros Usados", R.drawable.showcase_02));
    }

    @Override
    public Fragment getItem(int position) {

        ShowCaseModel showCasePage;

        if (showCasesModels != null && showCasesModels.size() - 1 > position) {
            showCasePage = showCasesModels.get(position);
            return ShowCase.newInstance(showCasePage.getTitle(), showCasePage.getImage());
        }

        if (showCasesModels != null && position == showCasesModels.size() - 1) {
            return new UsedShowCase();
        }

        return null;
    }

    @Override
    public int getCount() {
        return showCasesModels.size();
    }
}
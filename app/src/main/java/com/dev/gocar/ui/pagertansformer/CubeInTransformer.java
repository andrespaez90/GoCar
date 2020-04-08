package com.dev.gocar.ui.pagertansformer;


import android.view.View;

import androidx.viewpager.widget.ViewPager;

public class CubeInTransformer implements ViewPager.PageTransformer {


    @Override
    public void transformPage(View page, float position) {
        page.setRotationY(position * -30f);
    }

}
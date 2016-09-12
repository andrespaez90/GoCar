package com.dev.gocar.ui.Pagertansformer;


import android.support.v4.view.ViewPager;
import android.view.View;

public class CubeInTransformer implements ViewPager.PageTransformer {


    @Override
    public void transformPage(View page, float position) {
        page.setRotationY(position * -30f);
    }

}
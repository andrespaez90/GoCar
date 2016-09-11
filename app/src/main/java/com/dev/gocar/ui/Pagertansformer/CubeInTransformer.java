package com.dev.gocar.ui.Pagertansformer;


import android.view.View;

public class CubeInTransformer extends BaseTransformer {

    @Override
    protected void onTransform(View view, float position) {

        view.setPivotX(position > 0 ? 0 : view.getWidth());
        view.setPivotY(0);
        view.setRotationY(-90f * position);
    }

    @Override
    public boolean isPagingEnabled() {
        return true;
    }

}
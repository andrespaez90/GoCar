package com.dev.gocar.ui.widgets;

import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import com.dev.gocar.R;
import com.dev.gocar.databinding.ViewHeaderHomeBinding;

public class HeaderHomeView extends Toolbar implements View.OnClickListener {

    private OnHeaderClickListener heaerListener;

    private ViewHeaderHomeBinding binding;

    public HeaderHomeView(Context context) {
        super(context);
        init();
    }

    public HeaderHomeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HeaderHomeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        binding = ViewHeaderHomeBinding.inflate(inflater, this, true);
        addListeners();
    }

    private void addListeners() {
        findViewById(R.id.imageView_logo).setOnClickListener(this);
        binding.imageViewSearch.setOnClickListener(this);
    }


    public void setHeaderListener(OnHeaderClickListener listener){
        heaerListener = listener;
    }

    @Override
    public boolean isInEditMode() {
        return false;
    }

    public void setTitle(String title) {
        binding.textViewTitle.setText(title);
    }


    @Override
    public void onClick(View view) {

        int viewId = view.getId();

        switch (viewId){
            case R.id.imageView_logo:
                 if(heaerListener != null){
                     heaerListener.onLogoClick();
                 }
        }

    }

    public interface OnHeaderClickListener {

        void onLogoClick();

        void onGridClick();
    }
}

package com.dev.gocar.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.ndk.CrashlyticsNdk;
import com.dev.gocar.R;
import com.dev.gocar.databinding.ActivityMainBinding;
import com.dev.gocar.ui.pagertansformer.SlideOverTransformer;
import com.dev.gocar.ui.adapter.ShowRoomAdapter;
import com.dev.gocar.ui.model.ShowCaseModel;
import com.dev.gocar.ui.widgets.HeaderHomeView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener, HeaderHomeView.OnHeaderClickListener{


    private ActivityMainBinding binding;

    private HeaderHomeView headerHomeView;

    private ArrayList<ShowCaseModel> showRoomInfo;

    private ViewPager showRoomPager;

    private DrawerLayout drawer;

    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics(), new CrashlyticsNdk());

        init();

        addListener();
    }

    private void init() {

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        headerHomeView = binding.layoutMainContent.headerHomeView;

        showRoomPager = binding.layoutMainContent.viewPagerShowRoom;

        drawer = binding.drawerLayout;

        showRoomPager.setAdapter(new ShowRoomAdapter(getSupportFragmentManager(), getOnShowRoomContent()));

        showRoomPager.setPageTransformer(false, new SlideOverTransformer());

//        headerHomeView.setTitle(showRoomInfo.get(0).getTitle());
    }

    private void addListener(){

        headerHomeView.setHeaderListener(this);

        //binding.navView.setNavigationItemSelectedListener(this);

        showRoomPager.addOnPageChangeListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public ArrayList<ShowCaseModel> getOnShowRoomContent() {

        showRoomInfo = new ArrayList<>();

        //showRoomInfo.add(new ShowCaseModel("Audi A6",R.drawable.showcase_01));

        //showRoomInfo.add(new ShowCaseModel("Corsa",R.drawable.showcase_02));

        //showRoomInfo.add(new ShowCaseModel("Audi A6",R.drawable.showcase_01));

        //showRoomInfo.add(new ShowCaseModel("Corsa",R.drawable.showcase_02));

        return showRoomInfo;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        headerHomeView.setTitle(showRoomInfo.get(position).getTitle());
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onLogoClick() {
        drawer.openDrawer(GravityCompat.START);
    }

    @Override
    public void onGridClick() {

    }
}

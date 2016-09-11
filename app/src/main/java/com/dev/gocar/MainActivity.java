package com.dev.gocar;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.dev.gocar.databinding.ActivityMainBinding;
import com.dev.gocar.ui.HeaderHomeView;
import com.dev.gocar.ui.Pagertansformer.CubeInTransformer;
import com.dev.gocar.ui.Pagertansformer.ForegroundToBackgroundTransformer;
import com.dev.gocar.ui.Pagertansformer.TabletTransformer;
import com.dev.gocar.ui.adapter.ShowRoomAdapter;
import com.dev.gocar.ui.model.ShowCaseModel;

import java.util.ArrayList;

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

        init();

        addListener();
    }

    private void init() {

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        headerHomeView = binding.layoutMainContent.headerHomeView;

        showRoomPager = binding.layoutMainContent.viewPagerShowRoom;

        drawer = binding.drawerLayout;

        ShowRoomAdapter viewPagerAdapter = new ShowRoomAdapter(getSupportFragmentManager(), getOnShowRoomContent());

        showRoomPager.setAdapter(viewPagerAdapter);

        showRoomPager.setPageTransformer(false, new ForegroundToBackgroundTransformer());

        showRoomPager.addOnPageChangeListener(this);

        headerHomeView.setTitle(showRoomInfo.get(0).getTitle());
    }

    private void addListener(){

        headerHomeView.setHeaderListener(this);

        binding.navView.setNavigationItemSelectedListener(this);
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

        showRoomInfo.add(new ShowCaseModel("Audi A6",R.drawable.ic_menu_camera));

        showRoomInfo.add(new ShowCaseModel("Corsa",R.drawable.ic_menu_gallery));

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

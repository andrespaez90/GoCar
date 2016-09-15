package com.dev.gocar.ui.widgets.showroom;


import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.gocar.R;
import com.dev.gocar.databinding.FragmentCarListBinding;
import com.dev.gocar.ui.Itemdecoration.ItemDecorationColumns;
import com.dev.gocar.ui.adapter.UsedShowCaseAdapter;
import com.dev.gocar.ui.model.UsedShowCaseModel;

import java.util.ArrayList;


public class UsedShowCase extends ShowCase {

    private FragmentCarListBinding binding;

    private ArrayList<UsedShowCaseModel> usedCars;

    private UsedShowCaseAdapter listAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentCarListBinding.inflate(inflater, container, false);

        initView();

        return binding.getRoot();
    }

    private ArrayList<UsedShowCaseModel> getUsedCars(){

        usedCars = new ArrayList<>();

        usedCars.add(new UsedShowCaseModel("BMW Serie 4", "http://carroya.blob.core.windows.net/vehiculos/1674244/1674244_1_m.jpg",135000000));

        usedCars.add(new UsedShowCaseModel("Mazda 2 1.5","http://carroya.blob.core.windows.net/vehiculos/1679608/1679608_17_m.jpg",35500000));

        usedCars.add(new UsedShowCaseModel("Jetta 2.0 Trendline Mecánico Full Equipo 2009","http://carroya.blob.core.windows.net/vehiculos/1675641/1675641_1_m.jpg",32000000));

        usedCars.add(new UsedShowCaseModel("Fusion 3.0 V6 Automático 2012","http://carroya.blob.core.windows.net/vehiculos/1677207/1677207_1_m.jpg",40000000));

        usedCars.add(new UsedShowCaseModel("Ford Fiesta 2011","http://carroya.blob.core.windows.net/vehiculos/1661307/1661307_1_m.jpg",29000000));

        usedCars.add(new UsedShowCaseModel("BMW Serie 4", "http://carroya.blob.core.windows.net/vehiculos/1674244/1674244_1_m.jpg",135000000));

        usedCars.add(new UsedShowCaseModel("Mazda 2 1.5","http://carroya.blob.core.windows.net/vehiculos/1679608/1679608_17_m.jpg",35500000));

        usedCars.add(new UsedShowCaseModel("Jetta 2.0 Trendline Mecánico Full Equipo 2009","http://carroya.blob.core.windows.net/vehiculos/1675641/1675641_1_m.jpg",32000000));

        usedCars.add(new UsedShowCaseModel("Fusion 3.0 V6 Automático 2012","http://carroya.blob.core.windows.net/vehiculos/1677207/1677207_1_m.jpg",40000000));

        usedCars.add(new UsedShowCaseModel("Ford Fiesta 2011","http://carroya.blob.core.windows.net/vehiculos/1661307/1661307_1_m.jpg",29000000));

        usedCars.add(new UsedShowCaseModel("BMW Serie 4", "http://carroya.blob.core.windows.net/vehiculos/1674244/1674244_1_m.jpg",135000000));

        usedCars.add(new UsedShowCaseModel("Mazda 2 1.5","http://carroya.blob.core.windows.net/vehiculos/1679608/1679608_17_m.jpg",35500000));

        usedCars.add(new UsedShowCaseModel("Jetta 2.0 Trendline Mecánico Full Equipo 2009","http://carroya.blob.core.windows.net/vehiculos/1675641/1675641_1_m.jpg",32000000));

        usedCars.add(new UsedShowCaseModel("Fusion 3.0 V6 Automático 2012","http://carroya.blob.core.windows.net/vehiculos/1677207/1677207_1_m.jpg",40000000));

        usedCars.add(new UsedShowCaseModel("Ford Fiesta 2011","http://carroya.blob.core.windows.net/vehiculos/1661307/1661307_1_m.jpg",29000000));

        return usedCars;
    }


    private void initView() {

        RecyclerView carlist = binding.recycleCarList;

        listAdapter = new UsedShowCaseAdapter(getUsedCars(), getContext());

        carlist.setHasFixedSize(true);

        carlist.setAdapter(listAdapter);

        carlist.setLayoutManager(new GridLayoutManager(getContext(), 2));


        carlist.addItemDecoration(new ItemDecorationColumns(
                getResources().getDimensionPixelSize(R.dimen.spacing_smaller),
                2));

    }

}

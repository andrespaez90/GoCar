package com.dev.gocar.ui.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.gocar.databinding.ItemUsedShowCaseBinding;
import com.dev.gocar.ui.model.UsedShowCaseModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UsedShowCaseAdapter extends RecyclerView.Adapter<UsedShowCaseAdapter.DataViewHolder> {

    private ItemUsedShowCaseBinding binding;

    private ArrayList<UsedShowCaseModel> visibleItems;

    private ArrayList<UsedShowCaseModel> allItems;

    private Context mContext;

    public UsedShowCaseAdapter(ArrayList<UsedShowCaseModel> data, Context context) {

        super();

        mContext = context;

        setData(data);
    }

    public void setData(ArrayList data) {
        allItems = data;

        visibleItems = new ArrayList<>();

        visibleItems.addAll(allItems);
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        binding = ItemUsedShowCaseBinding.inflate(inflater, viewGroup, true);

        DataViewHolder tvh = new DataViewHolder(binding, mContext);

        return tvh;
    }

    @Override
    public void onBindViewHolder(DataViewHolder data, int i) {
        UsedShowCaseModel item = visibleItems.get(i);
        data.bindItem(item);
    }

    @Override
    public int getItemCount() {
        return visibleItems.size();
    }

    public void setFilter(String queryText) {

        visibleItems = new ArrayList<UsedShowCaseModel>();

        for (UsedShowCaseModel item : allItems) {

            if (item.getTitle().toLowerCase().contains(queryText)) {
                visibleItems.add(item);
            }
        }
        notifyDataSetChanged();
    }


    public static class DataViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ItemUsedShowCaseBinding binding;

        private Context mContext;
        private UsedShowCaseModel showCaseModel;

        public DataViewHolder(ItemUsedShowCaseBinding binding, Context context) {
            super(binding.getRoot());
            this.binding = binding;
            mContext = context;
        }

        public void bindItem(UsedShowCaseModel item) {
            showCaseModel = item;

            binding.textViewCarBrand.setText(showCaseModel.getTitle());

            binding.textViewCarPrice.setText(String.valueOf(showCaseModel.getPrice()));

            Picasso.with(mContext).load(showCaseModel.getImage()).into(binding.imageViewItemCase);
        }

        @Override
        public void onClick(View v) {
        }
    }
}
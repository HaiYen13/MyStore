package com.yenvth.mystore.shop;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yenvth.mystore.R;
import com.yenvth.mystore.categoryDetail.CategoryDetailActivity;
import com.yenvth.mystore.model.CategoryModel;
import com.yenvth.mystore.model.ProductItemModel;

import java.util.ArrayList;

public class ShopFragment extends Fragment implements CategoryAdaper.OnItemClickListener {
    private RecyclerView mRcvCatogory;
    private RecyclerView.Adapter mAdapter;
    private ArrayList<CategoryModel> categories = new ArrayList<>();



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop, container, false);
        initView(view);
        initAction();
        getData();
        return view;
    }

    private void initView(View view) {
        mRcvCatogory = view.findViewById(R.id.shop_rcv);
    }

    private void initAction() {


    }
    private void getData(){
        categories.add(new CategoryModel("Nike", R.id.categoties_img));
        categories.add(new CategoryModel("Converse", R.id.categoties_img));
        categories.add(new CategoryModel("Balenciaga", R.id.categoties_img));
        categories.add(new CategoryModel("Puma", R.id.categoties_img));
        categories.add(new CategoryModel("Asics", R.id.categoties_img));
        mAdapter = new CategoryAdaper(categories, getContext(), this);
        mRcvCatogory.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        mRcvCatogory.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void onClick(CategoryModel model, int pos) {
        Intent intent = new Intent(getContext(), CategoryDetailActivity.class);
        startActivity(intent);
    }
}

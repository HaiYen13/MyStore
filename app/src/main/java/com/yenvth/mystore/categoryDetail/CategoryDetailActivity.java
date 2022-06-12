package com.yenvth.mystore.categoryDetail;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yenvth.mystore.R;
import com.yenvth.mystore.model.ProductItemModel;

import java.util.ArrayList;

import static com.yenvth.mystore.R.id.item_home_img;

public class CategoryDetailActivity extends AppCompatActivity implements CategoryDetailAdapter.OnItemClickListener {
    private ImageView imgBack;
    private ImageView imgShape;
    private boolean isTable = true;
    private RecyclerView mRcvDetailCatogories;
    private CategoryDetailAdapter mDetailAdapter;
    private ArrayList<ProductItemModel> detailCategories = new ArrayList<>();
    private RecyclerView mRcvTag;
    private TagAdapter mTagAdapter;
    private ArrayList<String> itemTagList = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_category);
        initView();
        initAction();
        getData();
    }

    private void initView() {
        imgBack = findViewById(R.id.back_img);
        imgShape = findViewById(R.id.shape_img);
        mRcvDetailCatogories = findViewById(R.id.catogories_rcv);
        mRcvTag =findViewById(R.id.rcv_category_type);


    }

    private void initAction() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        imgShape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setProductLayout();
            }
        });
    }

    private void getData() {
        detailCategories.add(new ProductItemModel("New", item_home_img, 3, 10, "Boo", "T-shirt", "10$", "5$", false));
        detailCategories.add(new ProductItemModel("New", item_home_img, 3, 10, "Boo", "T-shirt", "10$", "5$", false));
        detailCategories.add(new ProductItemModel("New", item_home_img, 3, 10, "Boo", "T-shirt", "10$", "5$", false));
        detailCategories.add(new ProductItemModel("New", item_home_img, 3, 10, "Boo", "T-shirt", "10$", "5$", false));
        detailCategories.add(new ProductItemModel("New", item_home_img, 3, 10, "Boo", "T-shirt", "10$", "5$", false));
        mDetailAdapter = new CategoryDetailAdapter(detailCategories, this, this,1);
        mRcvDetailCatogories.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        mRcvDetailCatogories.setAdapter(mDetailAdapter);

        itemTagList.add("Low Top");
        itemTagList.add("Hight Top");
        itemTagList.add("Slip Top");
        itemTagList.add("Mid Top");

        mTagAdapter = new TagAdapter(itemTagList, this);
        mRcvTag.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        mRcvTag.setAdapter(mTagAdapter);

    }

    @Override
    public void onClick(ProductItemModel model, int pos) {

    }

    private void setProductLayout() {
        if (isTable) {
            mDetailAdapter = new CategoryDetailAdapter(detailCategories, this, this, 2);
            mRcvDetailCatogories.setLayoutManager(new GridLayoutManager(this, 2));
            mRcvDetailCatogories.setAdapter(mDetailAdapter);
        } else {
            mDetailAdapter = new CategoryDetailAdapter(detailCategories, this, this, 1);
            mRcvDetailCatogories.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
            mRcvDetailCatogories.setAdapter(mDetailAdapter);
        }
        isTable = !isTable;
    }
}

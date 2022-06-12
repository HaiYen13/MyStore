package com.yenvth.mystore.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yenvth.mystore.R;
import com.yenvth.mystore.model.ProductItemModel;
import java.util.ArrayList;

import static com.yenvth.mystore.R.id.item_home_img;

public class HomeFragment extends Fragment implements NewProductHomeAdapter.OnItemClickListener {
    private RecyclerView mRcvNewProductHome;
    private RecyclerView mRcvSaleProductHome;
    private NewProductHomeAdapter mNewProductAdapter;
    private NewProductHomeAdapter mSaleProductAdapter;
    private ArrayList<ProductItemModel> mListNewProductItemModels = new ArrayList<>();
    private ArrayList<ProductItemModel> mListSaleProductItemModels = new ArrayList<>();
    private Button btnSaleCheck;
    private TextView tvViewAll;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initViews(view);
        initAction();
        getData();
        return view;

    }
    private void initViews(View view){
        mRcvNewProductHome = view.findViewById(R.id.new_product_recyclerView);
        mRcvSaleProductHome = view.findViewById(R.id.sale_product_recyclerView);

        btnSaleCheck = view.findViewById(R.id.sale_check_btn);
        tvViewAll = view.findViewById(R.id.view_all_tv);

    }
    private void initAction(){
        btnSaleCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

    }
    private void getData(){

        mListNewProductItemModels.add(new ProductItemModel("New", item_home_img, 3, 10, "Boo", "BASAS", "10$", "5$", false));
        mListNewProductItemModels.add(new ProductItemModel("New", item_home_img, 3, 8, "Boo", "BASAS", "10$", "5$", false));
        mListNewProductItemModels.add(new ProductItemModel("New", item_home_img, 3, 8, "Boo", "BASAS", "10$", "5$", false));
        mListNewProductItemModels.add(new ProductItemModel("New", item_home_img, 3, 8, "Boo", "BASAS", "10$", "5$", false));
        mListNewProductItemModels.add(new ProductItemModel("New", item_home_img, 3, 8, "Boo", "BASAS", "10$", "5$", false));
        mListSaleProductItemModels.add(new ProductItemModel("20%", item_home_img, 4, 7, "Boo", "BASAS", "10$", "5$", false));
        mListSaleProductItemModels.add(new ProductItemModel("30%", item_home_img, 3, 6, "Boo", "BASAS", "10$", "5$", false));
        mListSaleProductItemModels.add(new ProductItemModel("30%", item_home_img, 3, 6, "Boo", "BASASt", "10$", "5$", false));
        mListSaleProductItemModels.add(new ProductItemModel("30%", item_home_img, 3, 6, "Boo", "BASAS", "10$", "5$", false));
        mNewProductAdapter = new NewProductHomeAdapter(mListNewProductItemModels,getContext(), this);
        mRcvNewProductHome.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        mRcvNewProductHome.setAdapter(mNewProductAdapter);
        mNewProductAdapter.notifyDataSetChanged();

        mSaleProductAdapter = new NewProductHomeAdapter(mListSaleProductItemModels, getContext(),this);
        mRcvSaleProductHome.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL,false));
//        mRcvSaleProductHome.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mRcvSaleProductHome.setAdapter(mSaleProductAdapter);
        mSaleProductAdapter.notifyDataSetChanged();
    }


    @Override
    public void onClick(ProductItemModel model, int pos) {

    }
}

package com.yenvth.mystore.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.yenvth.mystore.R;
import com.yenvth.mystore.model.ProductItem;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private RecyclerView mRcvNewProductHome;
    private HomeAdapter mAdapter;
    private ArrayList<ProductItem> productItems;
    boolean isPressed = false;
//button.setOnClickListener(buttonListener);
//
//    OnClickListener buttonListener = new OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            if(isPressed)
//                button.setBackgroundResource(R.drawable.icon1);
//            else
//                button.setBackgroundResource(R.drawable.icon2);
//
//            isPressed = !isPressed;
//        }
//    };
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        return view;

    }
}

package com.yenvth.mystore.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yenvth.mystore.R;
import com.yenvth.mystore.model.ProductItem;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHoder> {
    private ArrayList<ProductItem> productItemHomes;
    private Context context;
    private LayoutInflater mInflater;
    private AdapterView.OnItemClickListener mClickListener;

    //Data is passed into the constructor


    public HomeAdapter(ArrayList<ProductItem> productItemHomes, Context context) {
        this.productItemHomes = productItemHomes;
        this.context = context;
    }

    // inflates the row layout from xml when needed
    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = mInflater.inflate(R.layout.item_home, parent, false);
        return new ViewHoder(view);
    }
    // binds the data to the ImageView in each row
    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {
        ProductItem model = productItemHomes.get(position);



    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHoder extends RecyclerView.ViewHolder{
        private ImageView imgProduct;
        private RatingBar ratingBar;
        private TextView tvRatingPerson;
        private TextView tvBrandName;
        private TextView tvItemProductName;
        private TextView tvOldPrice;
        private TextView tvNewPrice;
        private ImageButton favoriteButton;

        public ViewHoder(@NonNull View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.item_home_img);
            ratingBar = itemView.findViewById(R.id.star_rating_bar);
            tvBrandName = itemView.findViewById(R.id.brand_name);
            tvRatingPerson = itemView.findViewById(R.id.person_rating);
            tvItemProductName = itemView.findViewById(R.id.item_product_name);
            tvOldPrice = itemView.findViewById(R.id.old_price);
            tvNewPrice = itemView.findViewById(R.id.new_price);
            favoriteButton = itemView.findViewById(R.id.favorite_img_btn);
        }
    }
}

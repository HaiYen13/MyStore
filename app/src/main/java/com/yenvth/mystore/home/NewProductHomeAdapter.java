package com.yenvth.mystore.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    private HomeAdapter.OnItemClickListener mClickListener;

    interface OnItemClickListener {
        void onClick(ProductItem model, int pos);
    }

    //Data is passed into the constructor
    public HomeAdapter(ArrayList<ProductItem> productItemHomes, Context context, HomeAdapter.OnItemClickListener mClickListener) {
        this.productItemHomes = productItemHomes;
        this.context = context;
        this.mClickListener = mClickListener;
    }

    // inflates the row layout from xml when needed
    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //
        View view = LayoutInflater.from(context).inflate(R.layout.item_new_product_home, parent, false);
        return new ViewHoder(view);
    }
    // binds the data to the ImageView in each row
    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {
        ProductItem model = productItemHomes.get(position);
        holder.imgProduct.setImageResource(R.drawable.img_home_recycler);
        holder.ratingBar.setRating(model.getStarNum());
        holder.tvRatingPerson.setText(model.getPerson() + "");
        holder.tvBrandName.setText(model.getBrandName() + "");
        holder.tvItemProductName.setText(model.getProductName() + "");
        holder.tvOldPrice.setText(model.getOld_price() + "");
        holder.tvNewPrice.setText(model.getNew_price() + "");
        if (model.isFavorite_btn() == false) {
            holder.favoriteButton.setImageResource(R.drawable.ic_of_button_favorite);
        } else {
            holder.favoriteButton.setImageResource(R.drawable.ic_checked_of_favorite_button);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.onClick(model, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productItemHomes.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder {     //Tượng trưng view của 1 item trong danh sách
        private TextView tvSaleNewProduct;
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
            tvSaleNewProduct = itemView.findViewById(R.id.sale_new_product);
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

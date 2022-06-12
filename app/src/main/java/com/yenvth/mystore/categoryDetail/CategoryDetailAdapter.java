package com.yenvth.mystore.categoryDetail;

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
import com.yenvth.mystore.model.ProductItemModel;

import java.util.ArrayList;

public class CategoryDetailAdapter extends RecyclerView.Adapter<CategoryDetailAdapter.ViewHoder> {
    private ArrayList<ProductItemModel> dataList;
    private Context context;
    private CategoryDetailAdapter.OnItemClickListener listener;
    private int type = 1;
    public interface OnItemClickListener {
        void onClick(ProductItemModel model, int pos);
    }

    public CategoryDetailAdapter(ArrayList<ProductItemModel> dataList, Context context, OnItemClickListener listener, int type) {
        this.dataList = dataList;
        this.context = context;
        this.listener = listener;
        this.type = type;
    }

    @Override
    public int getItemViewType(int position) {
        return type;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        if (viewType == 1) {
            view = LayoutInflater.from(context).inflate(R.layout.item_category_product_table, parent, false);
        } else if (viewType == 2) {
            view = LayoutInflater.from(context).inflate(R.layout.item_category_product_grid, parent, false);
        }
        return new ViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {
        ProductItemModel model = dataList.get(position);
//        holder.imgProduct.setImageResource(R.drawable.product_cato);
        holder.ratingBar.setRating(model.getStarNum());
        holder.tvRatingPerson.setText("(" + model.getPerson() + ")");
        holder.tvBrandName.setText(model.getBrandName() + "");
        holder.tvItemProductName.setText(model.getProductName() + "");
        holder.tvOldPrice.setText(model.getOld_price() + "");
        holder.tvNewPrice.setText(model.getNew_price() + "");
        if (!model.isFavorite_btn()) {
            holder.favoriteButton.setImageResource(R.drawable.ic_of_button_favorite);
        } else {
            holder.favoriteButton.setImageResource(R.drawable.ic_checked_of_favorite_button);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listener.onClick(model, position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    public class ViewHoder extends RecyclerView.ViewHolder {
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
            imgProduct = itemView.findViewById(R.id.img_product);
            ratingBar = itemView.findViewById(R.id.star_rating_bar);
            tvBrandName = itemView.findViewById(R.id.brand_name);
            tvRatingPerson = itemView.findViewById(R.id.person_rating);
            tvItemProductName = itemView.findViewById(R.id.tv_product_name);
            tvOldPrice = itemView.findViewById(R.id.tv_old_price);
            tvNewPrice = itemView.findViewById(R.id.tv_new_price);
            favoriteButton = itemView.findViewById(R.id.favorite_img_btn);
        }
    }
}

package com.yenvth.mystore.shop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yenvth.mystore.R;
import com.yenvth.mystore.model.CategoryModel;
import com.yenvth.mystore.model.ProductItemModel;

import java.util.ArrayList;

public class CategoryAdaper extends RecyclerView.Adapter<CategoryAdaper.ViewHoder>{
    private ArrayList<CategoryModel> categories;
    private Context context;
    private CategoryAdaper.OnItemClickListener mItemClickListener;

    interface OnItemClickListener {
        void onClick(CategoryModel model, int pos);
    }
    public CategoryAdaper(ArrayList<CategoryModel> categories, Context context, ShopFragment mItemClickListener) {
        this.categories = categories;
        this.context = context;
        this.mItemClickListener = mItemClickListener;
    }


    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_catogories_shop, parent, false);
        return new ViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {
        CategoryModel categoryModel = categories.get(position);
        holder.tvCategoryName.setText(categoryModel.getCategoryName());
        holder.imgCategoryImage.setImageResource(R.drawable.img_card_categories_shop);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemClickListener.onClick(categoryModel, position);
            }
        });
    }
    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ViewHoder  extends RecyclerView.ViewHolder{
        private TextView tvCategoryName;
        private ImageView imgCategoryImage;
        public ViewHoder(@NonNull View itemView) {
            super(itemView);
            tvCategoryName = itemView.findViewById(R.id.categories_name_tv);
            imgCategoryImage = itemView.findViewById(R.id.categoties_img);

        }
    }
}

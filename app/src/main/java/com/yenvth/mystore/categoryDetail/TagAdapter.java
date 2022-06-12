package com.yenvth.mystore.categoryDetail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yenvth.mystore.R;

import java.util.ArrayList;

public class TagAdapter extends RecyclerView.Adapter<TagAdapter.ViewHoder> {
    private ArrayList<String> dataList = new ArrayList<>();
    private Context context;

    public TagAdapter(ArrayList<String> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tag, parent, false);
        return new ViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {
        holder.tvItemTag.setText(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }



    public class ViewHoder extends RecyclerView.ViewHolder {
        private TextView tvItemTag;
        public ViewHoder(@NonNull View itemView) {
            super(itemView);
            tvItemTag = itemView.findViewById(R.id.tv_item_tag);

        }
    }

}

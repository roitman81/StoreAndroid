package com.example.roitm.retrofit2.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.roitm.retrofit2.ItemClickListener;
import com.example.roitm.retrofit2.R;
import com.example.roitm.retrofit2.model.Category;


import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>
{


    private ArrayList<Category> dataList;
    ItemClickListener itemClickListener;

    public CategoryAdapter(ArrayList<Category> dataList) {
        this.dataList = dataList;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_row_view, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, final int i) {
        final Category categoryAdapter = dataList.get(i);
        categoryViewHolder.idCategory.setText(dataList.get(i).getId());
        categoryViewHolder.nameCategory.setText(dataList.get(i).getName());

        categoryViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.OnItemClick(i,categoryAdapter);
            }
        });

        categoryViewHolder.nameCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataList.remove(i);
                notifyDataSetChanged();
            }
        });
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }



    class CategoryViewHolder extends RecyclerView.ViewHolder {

        TextView idCategory;
        EditText nameCategory;

        CategoryViewHolder(View itemView) {
            super(itemView);
            idCategory = itemView.findViewById(R.id.id_category);
            nameCategory = itemView.findViewById(R.id.name_category);

        }
    }
        public void setOnItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;

    }
        public void UpdateData(int position, Category categoryAdapter){

            dataList.remove(position);
            dataList.add(categoryAdapter);
            notifyItemChanged(position);
            notifyDataSetChanged();
        }
    }



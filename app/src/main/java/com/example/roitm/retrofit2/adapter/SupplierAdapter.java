package com.example.roitm.retrofit2.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.roitm.retrofit2.ItemClickListener;
import com.example.roitm.retrofit2.R;
import com.example.roitm.retrofit2.model.Suppl;

import java.util.ArrayList;

public class SupplierAdapter extends RecyclerView.Adapter<SupplierAdapter.SupplierViewHolder> {


    private ArrayList<Suppl> dataList;
    ItemClickListener itemClickListener;

    public SupplierAdapter(ArrayList<Suppl> dataList) {
        this.dataList = dataList;
    }

    @Override
    public SupplierAdapter.SupplierViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_row_view, parent, false);
        return new SupplierAdapter.SupplierViewHolder(view);
    }

    /*@Override
    public void onBindViewHolder(@NonNull SupplierViewHolder supplierViewHolder, int i) {

    }*/

    @Override
    public void onBindViewHolder(@NonNull SupplierAdapter.SupplierViewHolder supplierViewHolder, final int i) {
      /*  final Suppl SupplierAdapter = dataList.get(i);
        supplierViewHolder.tvIdCategory.setText(dataList.get(i).getPhoneNum());
        supplierViewHolder.tvNameCategory.setText(dataList.get(i).getName());

        supplierViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.OnItemClick(i,SupplierAdapter);
            }
        });

        supplierViewHolder.tvNameCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataList.remove(i);
                notifyDataSetChanged();
            }
        });*/
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void setOnItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }




    class SupplierViewHolder extends RecyclerView.ViewHolder {

        TextView tvIdCategory,tvNameCategory;


        SupplierViewHolder(View itemView) {
            super(itemView);
            tvIdCategory = itemView.findViewById(R.id.tv_id_category);
            tvNameCategory = itemView.findViewById(R.id.tv_name_category);

        }
    }


    public void UpdateData(int position, Suppl supplAdapter){

        dataList.remove(position);
        dataList.add(supplAdapter);
        notifyItemChanged(position);
        notifyDataSetChanged();

    }

}






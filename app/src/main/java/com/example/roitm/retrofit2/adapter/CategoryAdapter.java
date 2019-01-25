package com.example.roitm.retrofit2.adapter;

import android.app.AlertDialog;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.roitm.retrofit2.ItemClickListener;
import com.example.roitm.retrofit2.R;
import com.example.roitm.retrofit2.model.Category;
import com.example.roitm.retrofit2.my_interface.GetCategoryDataService;
import com.example.roitm.retrofit2.network.RetrofitInstance;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>
{
    String name_Category, id_Category;
    EditText update_name_category, update_id_category;
    AlertDialog.Builder builder;
    Button btnUpdate, btnDelete, btnCancel;
    AlertDialog dialog;
    ItemClickListener itemClickListener;

    private ArrayList<Category> dataList;
    GetCategoryDataService service = RetrofitInstance.getRetrofitInstance().create(GetCategoryDataService.class);
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
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, final int position) {
        final Category category = dataList.get(position);
        categoryViewHolder.tvIdCategory.setText(dataList.get(position).getId());
        categoryViewHolder.tvNameCategory.setText(dataList.get(position).getName());

        categoryViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                itemClickListener.OnItemClick(position,categoryAdapter);
                builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Update Category Info");
                builder.setCancelable(false);
                view = LayoutInflater.from(view.getContext()).inflate(R.layout.update_row_view,null,false);
                InitUpdateDialog(position,view,category);
                builder.setView(view);
                dialog = builder.create();
                dialog.show();

            }
        });

        categoryViewHolder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataList.remove(position);
                Call<Category> callCatDel = service.deleteCategory(position);
                callCatDel.enqueue(new Callback<Category>() {
                    @Override
                    public void onResponse(Call<Category> call, Response<Category> response) {
                        if (response.isSuccessful()) {
//                        Toast.makeText(.this, "User created successfully!", Toast.LENGTH_SHORT).show();
                            Log.i("INFO: ", "Category deleted at position: " + position);
                        }
                    }

                    @Override
                    public void onFailure(Call<Category> call, Throwable t) {
                        Log.e("ERROR: ", t.getMessage());
                    }
                });


                notifyDataSetChanged();
            }
        });


    }

    private void InitUpdateDialog(final int position, View view, Category category) {


        update_name_category = view.findViewById(R.id.update_name_category);
        update_id_category = view.findViewById(R.id.update_id_category);
        btnUpdate = view.findViewById(R.id.btn_update_user);
        btnCancel = view.findViewById(R.id.btn_update_cancel);
        update_name_category.setText(category.getName());
        update_id_category.setText(category.getId());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name_Category = update_name_category.getText().toString();
                id_Category = update_id_category.getText().toString();
                Category category = new Category();
                category.setName(name_Category);
                category.setId(id_Category);
                updateData(position, category);
                dialog.dismiss();
//                Toast.makeText(view, "User Updated..", Toast.LENGTH_SHORT).show();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void setOnItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }




    class CategoryViewHolder extends RecyclerView.ViewHolder {

        TextView tvIdCategory,tvNameCategory;
        Button btnDelete;

        CategoryViewHolder(View itemView) {
            super(itemView);
            tvIdCategory = itemView.findViewById(R.id.tv_id_category);
            tvNameCategory = itemView.findViewById(R.id.tv_name_category);
            btnDelete=itemView.findViewById(R.id.btnDelete);
        }
    }


        public void updateData(int position, final Category category){

            dataList.remove(position);
            dataList.add(category);
            notifyItemChanged(position);
            Call<Category> callCatUp = service.updateCategory(category);
            callCatUp.enqueue(new Callback<Category>() {
                @Override
                public void onResponse(Call<Category> call, Response<Category> response) {
                    if (response.isSuccessful()) {
//                        Toast.makeText(.this, "User created successfully!", Toast.LENGTH_SHORT).show();
                        Log.i("INFO: ", "Category updated at position: " + category.getId());
                    }
                }

                @Override
                public void onFailure(Call<Category> call, Throwable t) {
                    Log.e("ERROR: ", t.getMessage());
                }
            });


            notifyDataSetChanged();

        }

    }




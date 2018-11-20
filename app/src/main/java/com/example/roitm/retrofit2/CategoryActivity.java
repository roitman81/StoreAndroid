package com.example.roitm.retrofit2;

import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.roitm.retrofit2.adapter.CategoryAdapter;
import com.example.roitm.retrofit2.model.Category;
import com.example.roitm.retrofit2.my_interface.GetCategoryDataService;
import com.example.roitm.retrofit2.network.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;





public class CategoryActivity extends AppCompatActivity {

        EditText name;
        EditText update_name_category, update_id_category;
        EditText idCategory;
        CategoryAdapter adapter;
        RecyclerView recyclerView;
        Button add, delete, update, btnUpdate, btnDelete, btnCancel;
        List<Category> list = new ArrayList<>();
        String name_Category, id_Category;
        AlertDialog.Builder builder;

        AlertDialog dialog;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_category);

            delete = findViewById(R.id.btnDelete);
            update = findViewById(R.id.btnUpdate);
            name = findViewById(R.id.name_category);
            idCategory = findViewById(R.id.id_category);


            /** Create handle for the RetrofitInstance interface*/
            GetCategoryDataService service = RetrofitInstance.getRetrofitInstance().create(GetCategoryDataService.class);

            /** Call the method with parameter in the interface to get the notice data*/
            Call<ArrayList<Category>> call = service.getCategoryData();

            /**Log the URL called*/
            Log.wtf("URL Called", call.request().url() + "");

            call.enqueue(new Callback<ArrayList<Category>>() {

                @Override
                public void onResponse(Call<ArrayList<Category>> call, Response<ArrayList<Category>> response) {
                    generateCategoryList(response.body());


                }

                @Override
                public void onFailure(Call<ArrayList<Category>> call, Throwable t) {
                    Toast.makeText(com.example.roitm.retrofit2.CategoryActivity.this, "Something went wrong...Error message: " + t.getMessage(), Toast.LENGTH_SHORT).show();

                }

            });

        }

        /**
         * Method to generate List of notice using RecyclerView with custom adapter
         */
        private void generateCategoryList(ArrayList<Category> categoryArrayList) {

            Toast.makeText(this, categoryArrayList.get(1).getName(), Toast.LENGTH_LONG).show();


            recyclerView = findViewById(R.id.recycler_view_notice_list);

            adapter = new CategoryAdapter(categoryArrayList);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);


            delete = findViewById(R.id.btnDelete);
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    name_Category = name.getText().toString();
                 
                   id_Category = idCategory.getText().toString();
                    list.remove(id_Category);
                    list.remove(name_Category);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(com.example.roitm.retrofit2.CategoryActivity.this, "User Delete Success...", Toast.LENGTH_SHORT).show();


                }
            });

            add = findViewById(R.id.buttonNew);
            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    name_Category = name.getText().toString();
                    id_Category = idCategory.getText().toString();
                    Category category = new Category();
                    category.setId((id_Category));
                    category.setName(name_Category);
                    list.add(category);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(com.example.roitm.retrofit2.CategoryActivity.this, "User Add Success...", Toast.LENGTH_SHORT).show();
                    name.setText(" ");
                    idCategory.setText(" ");

                }
            });

            adapter.setOnItemClickListener(new ItemClickListener() {
                @Override
                public void OnItemClick(int position, Category category) {
                    builder = new AlertDialog.Builder(com.example.roitm.retrofit2.CategoryActivity.this);
                    builder.setTitle("Update User Info");
                    builder.setCancelable(false);
                    View view = LayoutInflater.from(com.example.roitm.retrofit2.CategoryActivity.this).inflate(R.layout.update_row_view, null, false);
                    InitUpdateDialog(position, view);
                    builder.setView(view);
                    dialog = builder.create();
                    dialog.show();
                }
            });
        }

        private void InitUpdateDialog(final int position, View view) {

            update_name_category = view.findViewById(R.id.update_name_category);
            update_id_category = view.findViewById(R.id.update_id_category);
            btnUpdate = view.findViewById(R.id.btn_update_user);
            btnCancel = view.findViewById(R.id.btn_update_cancel);
            update_name_category.setText(name_Category);
            update_id_category.setText(id_Category);

            btnUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    name_Category = update_name_category.getText().toString();
                    id_Category = update_id_category.getText().toString();
                    Category category = new Category();
                    category.setName(name_Category);
                    category.setId(id_Category);
                    adapter.UpdateData(position, category);
                    Toast.makeText(com.example.roitm.retrofit2.CategoryActivity.this, "User Updated..", Toast.LENGTH_SHORT).show();
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
        public boolean onCreateOptionsMenu(Menu menu) {
            // TODO Auto-generated method stub

            menu.add("menu1");
            menu.add("menu2");
            menu.add("menu3");
            menu.add("menu4");

            return super.onCreateOptionsMenu(menu);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // TODO Auto-generated method stub
            Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
            return super.onOptionsItemSelected(item);
        }
    }


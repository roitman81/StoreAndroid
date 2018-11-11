package com.example.roitm.retrofit2;



//https://medium.com/cr8resume/make-your-hand-dirty-with-retrofit-2-a-type-safe-http-client-for-android-and-java-c546f88b3a51
import android.service.autofill.UserData;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
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


public class MainActivity extends AppCompatActivity
{
    EditText name;
    EditText update_name_category;
    EditText idCategory;
     CategoryAdapter adapter;
     RecyclerView recyclerView;
    Button add,delete,update,btnUpdate,btnDelete,btnCancel;
    List<Category> list=new ArrayList<>();
    String name_Category,id_Category;
    AlertDialog.Builder builder;

    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        delete=findViewById(R.id.btnDelete);
        update=findViewById(R.id.btnUpdate);
         name =  findViewById(R.id.name_category);
        idCategory=findViewById(R.id.id_category);


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
                Toast.makeText(MainActivity.this, "Something went wrong...Error message: " + t.getMessage(), Toast.LENGTH_SHORT).show();

            }

        });





    }

    /** Method to generate List of notice using RecyclerView with custom adapter*/
    private void generateCategoryList(ArrayList<Category> categoryArrayList) {

        recyclerView = findViewById(R.id.recycler_view_notice_list);
        adapter = new CategoryAdapter(categoryArrayList);


        add=findViewById(R.id.buttonNew);
        add.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                name_Category = name.getText().toString();
                //  id_Category=idCategory.getText().toString();
                Category category = new Category();
                // category.setId((id_Category));
                category.setName(name_Category);

                list.add(category);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this,"User Add Success...",Toast.LENGTH_SHORT).show();
                name.setText("");
                idCategory.setText("");

            }
        });

        adapter.setOnItemClickListener(new ItemClickListener() {
            @Override
            public void OnItemClick(int position, Category category) {
                builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Update User Info");
                builder.setCancelable(false);
                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.update_row_view,null,false);
                InitUpdateDialog(position,view);
                builder.setView(view);
                dialog = builder.create();
                dialog.show();
            }
        });






}






    private void InitUpdateDialog(final int position, View view) {

        update_name_category = view.findViewById(R.id.update_name_category);
        btnUpdate = view.findViewById(R.id.btn_update_user);
        btnCancel = view.findViewById(R.id.btn_update_cancel);
        update_name_category.setText(name_Category);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name_Category = update_name_category.getText().toString();
                Category category = new Category();
                category.setName(name_Category);
                adapter.UpdateData(position, category);
                Toast.makeText(MainActivity.this, "User Updated..", Toast.LENGTH_SHORT).show();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

    }}





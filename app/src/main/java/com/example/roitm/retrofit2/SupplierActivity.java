/*
package com.example.roitm.retrofit2;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.roitm.retrofit2.adapter.SupplierAdapter;
import com.example.roitm.retrofit2.model.Category;
import com.example.roitm.retrofit2.model.Suppl;
import com.example.roitm.retrofit2.my_interface.GetCategoryDataService;
import com.example.roitm.retrofit2.my_interface.GetSupplierDataService;
import com.example.roitm.retrofit2.network.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SupplierActivity extends AppCompatActivity {
    EditText name;
    EditText update_name_sup, update_id_sup;
    EditText idSup;
    SupplierAdapter adapter;
    RecyclerView recyclerView;
    Button add, delete, update, btnUpdate, btnDelete, btnCancel;
    List<Suppl> list = new ArrayList<Suppl>();
    String name_Supplier, id_Supplier;
    AlertDialog.Builder builder;

    AlertDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier);
        delete = findViewById(R.id.btnDelete);
        update = findViewById(R.id.btnUpdate);
        name = findViewById(R.id.nameSupp);
        idSup = findViewById(R.id.idSupplier);

*/
/** Create handle for the RetrofitInstance interface*//*

        GetSupplierDataService service = RetrofitInstance.getRetrofitInstance().create(GetSupplierDataService.class);

        */
/** Call the method with parameter in the interface to get the notice data*//*

        Call<ArrayList<Suppl>> call = service.getSupplierData();

        */
/**Log the URL called*//*

        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<ArrayList<Suppl>>() {

            @Override
            public void onResponse(Call<ArrayList<Suppl>> call, Response<ArrayList<Suppl>> response) {
                generateSupplierList(response.body());


            }

            @Override
            public void onFailure(Call<ArrayList<Suppl>> call, Throwable t) {
                Toast.makeText(com.example.roitm.retrofit2.SupplierActivity.this, "Something went wrong...Error message: " + t.getMessage(), Toast.LENGTH_SHORT).show();

            }

        });

    }

    */
/**
     * Method to generate List of notice using RecyclerView with custom adapter
     *//*

    private void generateSupplierList(ArrayList<Suppl> supplArrayList) {

        Toast.makeText(this, supplArrayList.get(1).getName(), Toast.LENGTH_LONG).show();


        recyclerView = findViewById(R.id.recycler_view_notice_list);

        adapter = new SupplierAdapter(supplArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        delete = findViewById(R.id.btnDelete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name_Supplier = name.getText().toString();

                id_Supplier = idSup.getText().toString();
                list.remove(id_Supplier);
                list.remove(name_Supplier);
                adapter.notifyDataSetChanged();
                Toast.makeText(com.example.roitm.retrofit2.SupplierActivity.this, "User Delete Success...", Toast.LENGTH_SHORT).show();


            }
        });


        add = findViewById(R.id.buttonNew);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name_Supplier = name.getText().toString();
                id_Supplier = idSup.getText().toString();
                Suppl suppl = new Suppl();
                suppl.setCity((id_Supplier));
                suppl.setName(name_Supplier);
                list.add(suppl);
                adapter.notifyDataSetChanged();
                Toast.makeText(com.example.roitm.retrofit2.SupplierActivity.this, "User Add Success...", Toast.LENGTH_SHORT).show();
                name.setText(" ");
                idSup.setText(" ");

            }
        });

     adapter.setOnItemClickListener(new ItemClickListener() {
         @Override
         public void OnItemClick(int i, Category category) {

         }

        */
/* @Override
            public void OnItemClick(int position, Suppl suppl) {
                builder = new AlertDialog.Builder(com.example.roitm.retrofit2.SupplierActivity.this);
                builder.setTitle("Update User Info");
                builder.setCancelable(false);
                View view = LayoutInflater.from(com.example.roitm.retrofit2.SupplierActivity.this).inflate(R.layout.update_row_view, null, false);
                InitUpdateDialog(position, view);
                builder.setView(view);
                dialog = builder.create();
                dialog.show();
            }
        });
    }*//*


    private void InitUpdateDialog(final int position, View view) {

        update_name_sup = view.findViewById(R.id.update_name_category);
        update_id_sup = view.findViewById(R.id.update_id_category);
        btnUpdate = view.findViewById(R.id.btn_update_user);
        btnCancel = view.findViewById(R.id.btn_update_cancel);
        update_name_sup.setText(name_Supplier);
        update_id_sup.setText(id_Supplier);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name_Supplier = update_name_sup.getText().toString();
                id_Supplier = update_id_sup.getText().toString();
                Suppl suppl = new Suppl();
                suppl.setName(name_Supplier);
                suppl.setCity(id_Supplier);
                adapter.UpdateData(position, null);
                Toast.makeText(com.example.roitm.retrofit2.SupplierActivity.this, "User Updated..", Toast.LENGTH_SHORT).show();
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
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }


}

*/

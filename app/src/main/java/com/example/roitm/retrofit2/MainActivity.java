package com.example.roitm.retrofit2;



//https://medium.com/cr8resume/make-your-hand-dirty-with-retrofit-2-a-type-safe-http-client-for-android-and-java-c546f88b3a51
import android.content.Intent;
import android.service.autofill.UserData;
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


public class MainActivity extends AppCompatActivity {
    Button btnCategory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCategory=findViewById(R.id.buttonCat);
        btnCategory.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {



                        Intent intent=new Intent("android.intent.action.CategoryActivity");
                        startActivity(intent);

                    }
                }
        );
    }
}



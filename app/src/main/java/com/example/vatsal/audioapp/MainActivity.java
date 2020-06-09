package com.example.vatsal.audioapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.vatsal.audioapp.Adapters.Model.HorizontalModel;
import com.example.vatsal.audioapp.Adapters.Model.VerticalModel;
import com.example.vatsal.audioapp.Adapters.VerticalRecyclerViewAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView verticalRecyclerView;
    VerticalRecyclerViewAdapter adapter;
    ArrayList<VerticalModel> arrayListVertical =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        verticalRecyclerView=(RecyclerView) findViewById(R.id.recyclerview);
        verticalRecyclerView.setHasFixedSize(true);
        verticalRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        arrayListVertical=new ArrayList<>();
        adapter=new VerticalRecyclerViewAdapter(this,arrayListVertical);
        verticalRecyclerView.setAdapter(adapter);
        setData();
        //vertical adapter
    }

    private void setData() {

        for(int i=1;i<=5;i++)
        {
            VerticalModel verticalModel=new VerticalModel();
            verticalModel.setTitle("Title"+i);
            ArrayList<HorizontalModel> arraylist=new ArrayList<>();

            for(int j=0;j<=5;j++){
                HorizontalModel horizontalModel=new HorizontalModel();
                horizontalModel.setDescription("Description"+ j);
                horizontalModel.setName("Name"+j);
                arraylist.add(horizontalModel);
            }
            verticalModel.setArrayList(arraylist);

            arrayListVertical.add(verticalModel);
        }
        adapter.notifyDataSetChanged();
    }
}

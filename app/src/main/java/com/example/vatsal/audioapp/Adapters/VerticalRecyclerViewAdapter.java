package com.example.vatsal.audioapp.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vatsal.audioapp.Adapters.Model.HorizontalModel;
import com.example.vatsal.audioapp.Adapters.Model.VerticalModel;
import com.example.vatsal.audioapp.R;

import java.util.ArrayList;

/**
 * Created by Vatsal on 09-06-2020.
 */

public class VerticalRecyclerViewAdapter extends RecyclerView.Adapter<VerticalRecyclerViewAdapter.VerticalRVViewHolder> {

    Context context;
    ArrayList<VerticalModel> arrayList;


    public VerticalRecyclerViewAdapter(Context context,ArrayList<VerticalModel> arrayList){
        this.context=context;
        this.arrayList=arrayList;
    }


    @Override
    public VerticalRVViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_ver,viewGroup,false);
        return new VerticalRVViewHolder(view);

    }


    @Override
    public void onBindViewHolder(VerticalRVViewHolder verticalRVViewHolder, int i) {
        VerticalModel verticalModel=arrayList.get(i);
        String title=verticalModel.getTitle();
        ArrayList<HorizontalModel> singleitem=verticalModel.getArrayList();

        verticalRVViewHolder.textViewTitle.setText(title);
        HorizontalRecycleViewAdapter horizontalRecycleViewAdapter=new HorizontalRecycleViewAdapter(context,singleitem);
        verticalRVViewHolder.recyclerView.setHasFixedSize(true);
        verticalRVViewHolder.recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));

        verticalRVViewHolder.recyclerView.setAdapter(horizontalRecycleViewAdapter);


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public  class VerticalRVViewHolder extends RecyclerView.ViewHolder
    {

        RecyclerView recyclerView;
        TextView textViewTitle;
        public VerticalRVViewHolder(View itemView) {
            super(itemView);
            recyclerView=(RecyclerView)itemView.findViewById(R.id.recyclerview1);
            textViewTitle=(TextView)itemView.findViewById(R.id.textTitle1);
        }
    }
}
package com.example.vatsal.audioapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vatsal.audioapp.Adapters.Model.HorizontalModel;
import com.example.vatsal.audioapp.MainActivity;
import com.example.vatsal.audioapp.MusicActivity;
import com.example.vatsal.audioapp.R;

import java.util.ArrayList;

/**
 * Created by Vatsal on 09-06-2020.
 */




public class HorizontalRecycleViewAdapter extends RecyclerView.Adapter<HorizontalRecycleViewAdapter.HorizontalRVViewHolder>
{



    Context context;
    ArrayList<HorizontalModel> arrayList;

    public HorizontalRecycleViewAdapter(Context context, ArrayList<HorizontalModel> arrayList){

        this.context=context;
        this.arrayList=arrayList;
    }
    @NonNull
    @Override
    public HorizontalRVViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_hor,viewGroup,false);
        return new HorizontalRVViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalRVViewHolder horizontalRVViewHolder, int i) {
        final HorizontalModel horizontalModel=arrayList.get(i);
        horizontalRVViewHolder.textViewTitle.setText(horizontalModel.getName());
        horizontalRVViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //Toast.makeText(context,horizontalModel.getName(),Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(context,MusicActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class HorizontalRVViewHolder extends RecyclerView.ViewHolder{

        TextView textViewTitle;
        ImageView imageViewThumb;
        public HorizontalRVViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle =(TextView)itemView.findViewById(R.id.textTitleHorizontal);
            imageViewThumb=(ImageView)itemView.findViewById(R.id.ivThumb);
        }
    }

}

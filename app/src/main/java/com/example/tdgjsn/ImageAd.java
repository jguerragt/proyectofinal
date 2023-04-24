package com.example.tdgjsn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ImageAd  extends RecyclerView.Adapter<ImageAd.MyViewHolder> {


    Context context;
    ArrayList<Grupos> imagesArrayList;



    public ImageAd(Context context, ArrayList<Grupos> imagesArrayList){
        this.context = context;
        this.imagesArrayList= imagesArrayList;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder (@NonNull
                                                              ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.list_item_image, parent, false);



        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAd.MyViewHolder holder, int position){

        Grupos grupos = imagesArrayList.get(position);

        holder.url.setText(grupos.getUrl());

        Glide.with(context).load(grupos.getUrl()).into(holder.img);



    }

    @Override
    public  int getItemCount(){
        return imagesArrayList.size() ;
    }


    public static class MyViewHolder extends  RecyclerView.ViewHolder{
        ImageView img;
        TextView url;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            url=itemView.findViewById(R.id.tvtext);
            img = itemView.findViewById(R.id.tvimg);



        }
    }


}

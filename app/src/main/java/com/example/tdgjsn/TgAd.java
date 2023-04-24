package com.example.tdgjsn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class TgAd extends RecyclerView.Adapter<TgAd.MyViewHolder> {

    Context context;
    ArrayList<TablaGeneral> imagesArrayList;

    public TgAd(Context context, ArrayList<TablaGeneral> imagesArrayList){
        this.context = context;
        this.imagesArrayList= imagesArrayList;
    }

    @NonNull
    @Override
    public TgAd.MyViewHolder onCreateViewHolder (@NonNull
                                                            ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.list_item_tg, parent, false);



        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TgAd.MyViewHolder holder, int position){

        TablaGeneral tablageneral = imagesArrayList.get(position);

        holder.tg.setText(tablageneral.getTg());

        Glide.with(context).load(tablageneral.getTg()).into(holder.img);



    }

    @Override
    public  int getItemCount(){
        return imagesArrayList.size() ;
    }


    public static class MyViewHolder extends  RecyclerView.ViewHolder{
        ImageView img;
        TextView tg;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tg=itemView.findViewById(R.id.tvtgtext);
            img = itemView.findViewById(R.id.tvtg);



        }
    }



}

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

public class JnAd extends RecyclerView.Adapter<JnAd.MyViewHolder>{

        Context context;
        ArrayList<Calendario> imagesArrayList;

    public JnAd(Context context, ArrayList<Calendario> imagesArrayList){
        this.context = context;
        this.imagesArrayList= imagesArrayList;
    }

    @NonNull
    @Override
    public JnAd.MyViewHolder onCreateViewHolder (@NonNull
                                                         ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.list_item_jn, parent, false);



        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull JnAd.MyViewHolder holder, int position){

        Calendario calendario = imagesArrayList.get(position);

        holder.jn.setText(calendario.getJn());

        Glide.with(context).load(calendario.getJn()).into(holder.img);



    }

    @Override
    public  int getItemCount(){
        return imagesArrayList.size() ;
    }


    public static class MyViewHolder extends  RecyclerView.ViewHolder{
        ImageView img;
        TextView jn;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            jn=itemView.findViewById(R.id.tvjntext);
            img = itemView.findViewById(R.id.tvjn);



        }
    }


}

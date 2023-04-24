package com.example.tdgjsn;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    Context context;
    ArrayList<Champs> userArrayList;



    public MyAdapter(Context context, ArrayList<Champs> userArrayList){
        this.context = context;
        this.userArrayList = userArrayList;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder (@NonNull
    ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.item_r, parent, false);



        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position){

        Champs champs = userArrayList.get(position);

        holder.camp.setText(champs.getCamp());
        holder.subc.setText(champs.getSubc());
        holder.result.setText(champs.getResult());
        holder.torn.setText(champs.getTorn());


    }

    @Override
    public  int getItemCount(){
        return userArrayList.size() ;
    }


    public static class MyViewHolder extends  RecyclerView.ViewHolder{

        TextView camp, subc, result, torn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            camp=itemView.findViewById(R.id.tvchamp);
            subc=itemView.findViewById(R.id.tvchamp2);
            result=itemView.findViewById(R.id.tvresul);
            torn = itemView.findViewById(R.id.tvtorn);



        }
    }


}

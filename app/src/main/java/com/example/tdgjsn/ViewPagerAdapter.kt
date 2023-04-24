package com.example.tdgjsn

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import java.text.FieldPosition

class ViewPagerAdapter(private val images:List<Int>):RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {
    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */

    class ViewPagerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val imageVIew:ImageView=itemView.findViewById(R.id.ivImage)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int):ViewPagerAdapter.ViewPagerViewHolder{
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return ViewPagerViewHolder(view)


    }

    override fun onBindViewHolder(holder: ViewPagerAdapter.ViewPagerViewHolder, position: Int){
        val curImage=images[position]
        holder.imageVIew.setImageResource(curImage)
    }

    override fun getItemCount(): Int {
        return images.size
    }




}
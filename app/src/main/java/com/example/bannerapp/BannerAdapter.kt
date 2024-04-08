package com.example.bannerapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.request.RequestOptions
import com.example.bannerapp.databinding.BannerItemBinding

class BannerViewHolder(private var bannerItemBinding: BannerItemBinding): RecyclerView.ViewHolder(bannerItemBinding.root) {

    fun bindData(url:String,context: Context){
        val request = RequestOptions().transform(CenterInside())
        Glide.with(context)
            .load(url)
            .apply(request)
            .into(bannerItemBinding.bannerImg)
    }

}

class BannerAdapter(private val list: List<String>,private val context: Context):Adapter<BannerViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val binding = BannerItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BannerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.bindData(list[position],context)
    }

}
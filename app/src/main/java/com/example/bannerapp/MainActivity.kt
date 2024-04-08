package com.example.bannerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.example.bannerapp.databinding.ActivityMainBinding
import com.example.bannerapp.databinding.BannerItemBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var listOfBanner = listOf<String>("https://ik.imagekit.io/46cgl7uvt/Banner/New%20Collections.png?updatedAt=1712583342400","https://ik.imagekit.io/46cgl7uvt/Banner/New%20Collections.png?updatedAt=1712583342400")

        binding.banner.apply {
            adapter = BannerAdapter(listOfBanner,context)
            offscreenPageLimit = 3
            getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            val compositePageTransformer = CompositePageTransformer().apply {
                addTransformer(MarginPageTransformer(40))
            }
            setPageTransformer(compositePageTransformer)
            if (listOfBanner.size>1){
                binding.dotIndicator.attachTo(this)
            }
        }
    }
}
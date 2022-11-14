package com.example.librarytester

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.librarytester.databinding.ItemRecyclerCarMediaBinding

class CarouselAdapters(val context: Context) :
    RecyclerView.Adapter<CarouselAdapters.CarouselAdapterViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CarouselAdapterViewHolder {
        return CarouselAdapterViewHolder(
            ItemRecyclerCarMediaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(
        holder: CarouselAdapterViewHolder,
        position: Int
    ) {
//No data to bind
    }

    override fun getItemCount(): Int {
        return 5
    }

    inner class CarouselAdapterViewHolder(val binding: ItemRecyclerCarMediaBinding) :
        RecyclerView.ViewHolder(binding.root)

}

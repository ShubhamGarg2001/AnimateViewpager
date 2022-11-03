package com.example.librarytester

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.librarytester.databinding.ItemRecyclerBinding

class CarouselAdapter(val context: Context) :
    RecyclerView.Adapter<CarouselAdapter.CarouselAdapterViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CarouselAdapterViewHolder {
        return CarouselAdapterViewHolder(
            ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(
        holder: CarouselAdapterViewHolder,
        position: Int
    ) {
        when (position) {
            0 -> holder.binding.imageview.background = context.getDrawable(R.drawable.image1)
            1 -> holder.binding.imageview.background = context.getDrawable(R.drawable.image2)
            2 -> holder.binding.imageview.background = context.getDrawable(R.drawable.image3)
            3 -> holder.binding.imageview.background = context.getDrawable(R.drawable.image4)
            4 -> holder.binding.imageview.background = context.getDrawable(R.drawable.image5)

        }

    }

    override fun getItemCount(): Int {
        return 5
    }

    inner class CarouselAdapterViewHolder(val binding: ItemRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root)

}

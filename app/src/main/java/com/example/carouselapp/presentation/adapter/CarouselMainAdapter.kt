package com.example.carouselapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.carouselapp.databinding.ItemCarouselBinding
import com.example.carouselapp.utils.loadImageFromUrl
import com.example.data.entity.Device

class CarouselMainAdapter : ListAdapter<Device, CarouselMainAdapter.ViewHolder>(CatalogDiff()) {

    inner class ViewHolder(private val binding: ItemCarouselBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(data: Device) {
            binding.ivCarousel.loadImageFromUrl(data.imgUrl)
        }
    }

    class CatalogDiff : DiffUtil.ItemCallback<Device>() {
        override fun areItemsTheSame(oldItem: Device, newItem: Device): Boolean {
            return oldItem.type.ordinal == newItem.type.ordinal
        }

        override fun areContentsTheSame(
            oldItem: Device,
            newItem: Device
        ) = oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemCarouselBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position).run { holder.bindData(this) }
    }
}
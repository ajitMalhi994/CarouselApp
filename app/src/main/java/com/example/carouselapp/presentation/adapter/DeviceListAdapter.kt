package com.example.carouselapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.carouselapp.databinding.ItemDeviceInfoBinding
import com.example.carouselapp.utils.loadImageFromUrl
import com.example.data.entity.DeviceDescription

class DeviceListAdapter :
    ListAdapter<DeviceDescription, DeviceListAdapter.ViewHolder>(DeviceListDiff()) {

    inner class ViewHolder(private val binding: ItemDeviceInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(data: DeviceDescription) {
            with(binding) {
                ivDevice.loadImageFromUrl(data.itemImage)
                tvTitle.text = data.title
            }
        }
    }

    class DeviceListDiff : DiffUtil.ItemCallback<DeviceDescription>() {
        override fun areItemsTheSame(
            oldItem: DeviceDescription,
            newItem: DeviceDescription
        ): Boolean {
            return oldItem.title.contentEquals(newItem.title)
        }

        override fun areContentsTheSame(
            oldItem: DeviceDescription,
            newItem: DeviceDescription
        ) = oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemDeviceInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position).run { holder.bindData(this) }
    }
}
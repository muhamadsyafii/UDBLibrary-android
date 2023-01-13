package com.ransyadev.udblibrary.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ransyadev.udblibrary.data.model.Novel
import com.ransyadev.udblibrary.databinding.ItemRecommendedBinding

class NovelAdapter : ListAdapter<Novel, NovelAdapter.ViewHolder>(NovelDiffCallBack()){

    var onItemClick : () -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemRecommendedBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bindData(getItem(position))
    }

    inner class ViewHolder(private val binding : ItemRecommendedBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(data : Novel){
            binding.run {
                ivRecommended.setImageResource(data.image)
                tvTitle.text = data.title
                tvDesc.text = data.author
                root.setOnClickListener {
                    onItemClick.invoke()
                }
            }
        }
    }

    class NovelDiffCallBack : DiffUtil.ItemCallback<Novel>(){
        override fun areItemsTheSame(oldItem: Novel, newItem: Novel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Novel, newItem: Novel): Boolean {
            return oldItem == newItem
        }

    }

}

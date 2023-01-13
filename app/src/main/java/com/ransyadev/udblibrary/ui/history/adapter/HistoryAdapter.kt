package com.ransyadev.udblibrary.ui.history.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ransyadev.udblibrary.data.model.History
import com.ransyadev.udblibrary.databinding.ItemHistoryBinding

class HistoryAdapter : ListAdapter<History, HistoryAdapter.ViewHolder>(HistoryDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(ItemHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bindData(getItem(position))
    }

    class ViewHolder(private val binding : ItemHistoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(data : History){
            binding.run {
                ivHistory.setImageResource(data.image)
                tvTitle.text = data.title
                tvAuthor.text = data.author
                tvKembali.text = data.kembali
                tvPinjam.text = data.pinjam
            }
        }
    }

    class HistoryDiffCallBack : DiffUtil.ItemCallback<History>() {
        override fun areItemsTheSame(oldItem: History, newItem: History): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: History, newItem: History): Boolean {
            return oldItem == newItem
        }

    }
}

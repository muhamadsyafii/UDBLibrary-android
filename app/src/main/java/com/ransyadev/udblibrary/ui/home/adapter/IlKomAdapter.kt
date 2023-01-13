package com.ransyadev.udblibrary.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ransyadev.udblibrary.data.model.IlKom
import com.ransyadev.udblibrary.databinding.ItemIlkomBinding

class IlKomAdapter : ListAdapter<IlKom, IlKomAdapter.ViewHolder>(IlKomDiffCallBack()) {

    var onItemClick : () -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemIlkomBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bindData(getItem(position))
    }


    inner class ViewHolder (private val binding : ItemIlkomBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindData(data : IlKom){
            binding.run {
                ivIlkom.setImageResource(data.image)
                tvTitle.text = data.title
                root.setOnClickListener {
                    onItemClick.invoke()
                }
            }
        }
    }

    class IlKomDiffCallBack : DiffUtil.ItemCallback<IlKom>() {
        override fun areItemsTheSame(oldItem: IlKom, newItem: IlKom): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: IlKom, newItem: IlKom): Boolean {
            return oldItem == newItem
        }

    }

}

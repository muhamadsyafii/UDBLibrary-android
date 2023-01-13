package com.ransyadev.udblibrary.ui.cart.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ransyadev.udblibrary.data.model.Cart
import com.ransyadev.udblibrary.databinding.ItemCartBinding

class CartAdapter : ListAdapter<Cart, CartAdapter.ViewHolder>(CartDiffCallBack()) {
    class CartDiffCallBack : DiffUtil.ItemCallback<Cart>(){
        override fun areItemsTheSame(oldItem: Cart, newItem: Cart): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Cart, newItem: Cart): Boolean {
            return oldItem == newItem
        }

    }

    class ViewHolder (private val binding : ItemCartBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindData(data : Cart){
            binding.run {
                ivCart.setImageResource(data.image)
                tvTitle.text = data.title
                tvAuthor.text = data.author
                tvYear.text = data.year
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemCartBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bindData(getItem(position))
    }
}

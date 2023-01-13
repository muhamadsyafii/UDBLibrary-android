package com.ransyadev.udblibrary.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ransyadev.udblibrary.data.dummy.cartList
import com.ransyadev.udblibrary.databinding.FragmentCartBinding
import com.ransyadev.udblibrary.ui.cart.adapter.CartAdapter

class CartFragment : Fragment() {

    private lateinit var binding : FragmentCartBinding
    private val cartAdapter by lazy { CartAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentCartBinding.inflate(inflater, container, false)

        initView()
        return binding.root
    }

    private fun initView() {
        cartAdapter.submitList(cartList)
        val layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.rvCart.layoutManager = layoutManager
        binding.rvCart.adapter = cartAdapter
    }

}

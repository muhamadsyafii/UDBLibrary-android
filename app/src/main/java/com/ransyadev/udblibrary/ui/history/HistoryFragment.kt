package com.ransyadev.udblibrary.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ransyadev.udblibrary.data.dummy.historyList
import com.ransyadev.udblibrary.databinding.FragmentHistoryBinding
import com.ransyadev.udblibrary.ui.history.adapter.HistoryAdapter


class HistoryFragment : Fragment() {

    private lateinit var binding : FragmentHistoryBinding
    private val historyAdapter by lazy { HistoryAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentHistoryBinding.inflate(inflater, container, false)

        initView()
       return binding.root
    }

    private fun initView() {
        historyAdapter.submitList(historyList)
        val layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.rvHistory.layoutManager = layoutManager
        binding.rvHistory.adapter = historyAdapter
    }

}

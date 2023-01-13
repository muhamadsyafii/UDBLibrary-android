package com.ransyadev.udblibrary.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ransyadev.udblibrary.data.dummy.ilKomList
import com.ransyadev.udblibrary.data.dummy.novelList
import com.ransyadev.udblibrary.databinding.FragmentHomeBinding
import com.ransyadev.udblibrary.ui.detail.DetailActivity
import com.ransyadev.udblibrary.ui.home.adapter.IlKomAdapter
import com.ransyadev.udblibrary.ui.home.adapter.NovelAdapter
import com.ransyadev.udblibrary.utils.openActivity

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private val novelAdapter by lazy { NovelAdapter() }
    private val ilKomAdapter by lazy { IlKomAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        initView()
        return binding.root
    }

    private fun initView() {
        setupIlKom()
        setupNovel()
    }

    private fun setupIlKom() {
        ilKomAdapter.submitList(ilKomList)
        val layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        binding.rvIlkom.layoutManager = layoutManager
        binding.rvIlkom.adapter = ilKomAdapter
        ilKomAdapter.onItemClick = {
            openActivity(DetailActivity::class.java)
        }
    }

    private fun setupNovel() {
        novelAdapter.submitList(novelList)
        val layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvRecommended.layoutManager = layoutManager
        binding.rvRecommended.adapter = novelAdapter
        novelAdapter.onItemClick = {
            openActivity(DetailActivity::class.java)
        }
    }

}

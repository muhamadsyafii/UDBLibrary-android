package com.ransyadev.udblibrary.ui.profile

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ransyadev.udblibrary.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    private lateinit var binding : FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentProfileBinding.inflate(inflater, container, false)

        initView()
        return binding.root
    }

    private fun initView() {
        binding.btnAction.setOnClickListener {
            showDialogLogout()
        }
    }

    private fun showDialogLogout() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Informasi")
        builder.setMessage("Apakah anda yakin ingin keluar dari aplikasi ?")
        builder.setPositiveButton("Ya") { dialog, _ ->
            dialog.dismiss()
           requireActivity().finishAffinity()
        }

        builder.setNegativeButton("Tidak") { dialog, _ ->
            dialog.dismiss()
        }
        builder.show()
    }


}

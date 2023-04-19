package com.example.spacechatapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.spacechatapp.databinding.FragmentBottomBinding
import com.example.spacechatapp.presentation.ui.baseFragment.BaseFragment
import com.example.spacechatapp.presentation.ui.baseFragment.Inflater


class BottomFragment : BaseFragment<FragmentBottomBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun inflate(): Inflater<FragmentBottomBinding> {
        return FragmentBottomBinding::inflate
    }

}
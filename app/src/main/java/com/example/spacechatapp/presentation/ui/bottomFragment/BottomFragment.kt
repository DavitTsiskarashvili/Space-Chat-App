package com.example.spacechatapp

import com.example.spacechatapp.databinding.FragmentBottomBinding
import com.example.spacechatapp.common.BaseFragment
import com.example.spacechatapp.common.Inflater


class BottomFragment : BaseFragment<FragmentBottomBinding>() {

    override fun inflate(): Inflater<FragmentBottomBinding> {
        return FragmentBottomBinding::inflate
    }

    override fun onBind() {
    }

}
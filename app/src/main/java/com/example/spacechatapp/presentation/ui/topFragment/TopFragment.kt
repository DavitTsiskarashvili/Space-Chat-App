package com.example.spacechatapp.presentation.ui.topFragment

import com.example.spacechatapp.common.BaseFragment
import com.example.spacechatapp.common.Inflater
import com.example.spacechatapp.databinding.FragmentTopBinding


class TopFragment : BaseFragment<FragmentTopBinding>() {

    override fun inflate(): Inflater<FragmentTopBinding> {
        return FragmentTopBinding::inflate
    }

    override fun onBind() {
    }

}
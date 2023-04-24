package com.example.spacechatapp.presentation.ui.topFragment

import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import com.example.spacechatapp.R
import com.example.spacechatapp.common.BaseFragment
import com.example.spacechatapp.common.Inflater
import com.example.spacechatapp.databinding.FragmentTopBinding
import java.util.Collections.min
import kotlin.math.min


class TopFragment : BaseFragment<FragmentTopBinding>() {

    override fun inflate(): Inflater<FragmentTopBinding> {
        return FragmentTopBinding::inflate
    }

    override fun onBind() {
    }


}
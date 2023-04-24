package com.example.spacechatapp.presentation.ui.ChatFragment

import com.example.spacechatapp.common.BaseFragment
import com.example.spacechatapp.common.Inflater
import com.example.spacechatapp.databinding.FragmentChatBinding
import com.example.spacechatapp.presentation.ui.adapters.ChatAdapter


class ChatFragment : BaseFragment<FragmentChatBinding, ChatViewModel>() {

    override fun inflate(): Inflater<FragmentChatBinding> {
        return FragmentChatBinding::inflate
    }

    override fun viewModelClass(): Class<ChatViewModel> {
        return ChatViewModel::class.java
    }

    private lateinit var chatAdapter: ChatAdapter

    override fun onBind() {
    }

}
package com.example.spacechatapp.presentation.chatFragment_ui

import com.example.spacechatapp.databinding.FragmentChatBinding
import com.example.spacechatapp.presentation.base.BaseFragment
import com.example.spacechatapp.presentation.base.Inflater
import com.example.spacechatapp.presentation.chatFragment_adapter.ChatAdapter
import com.example.spacechatapp.presentation.chatFragment_vm.ChatViewModel


class ChatFragment() : BaseFragment<FragmentChatBinding, ChatViewModel>() {

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
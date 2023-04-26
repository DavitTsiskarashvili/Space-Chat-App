package com.example.spacechatapp.presentation.ui.chatFragment

import com.example.spacechatapp.databinding.FragmentChatBinding
import com.example.spacechatapp.domain.model.UserType
import com.example.spacechatapp.presentation.base.BaseFragment
import com.example.spacechatapp.presentation.base.Inflater
import com.example.spacechatapp.presentation.ui.adapter.ChatAdapter
import com.example.spacechatapp.presentation.ui.viewModel.ChatViewModel


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
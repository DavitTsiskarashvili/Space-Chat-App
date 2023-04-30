package com.space.chatApp.presentation.chat_screen.ui

import com.space.chat.databinding.FragmentChatBinding
import com.space.chatApp.presentation.base.BaseFragment
import com.space.chatApp.presentation.base.Inflater
import com.space.chatApp.presentation.chat_screen.adapter.ChatAdapter
import com.space.chatApp.presentation.chat_screen.viewModel.ChatViewModel


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
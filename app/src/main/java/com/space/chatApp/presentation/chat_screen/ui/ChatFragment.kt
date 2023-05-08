package com.space.chatApp.presentation.chat_screen.ui

import androidx.lifecycle.lifecycleScope
import com.space.chat.databinding.FragmentChatBinding
import com.space.chatApp.common.extensions.isNetworkAvailable
import com.space.chatApp.presentation.base.BaseFragment
import com.space.chatApp.presentation.base.Inflater
import com.space.chatApp.presentation.chat_screen.adapter.ChatAdapter
import com.space.chatApp.presentation.chat_screen.viewModel.ChatViewModel
import kotlinx.coroutines.launch
import kotlin.reflect.KClass


class ChatFragment() : BaseFragment<FragmentChatBinding, ChatViewModel>() {

    override fun inflate(): Inflater<FragmentChatBinding> {
        return FragmentChatBinding::inflate
    }

    override val viewModelClass: KClass<ChatViewModel>
        get() = ChatViewModel::class


    private val adapter by lazy {
        ChatAdapter(listener)
    }

    override fun onBind(viewModel: ChatViewModel) {
        with(viewModel) {
            initRecycler(this)
            sendButtonListener(this)
        }
    }

    private fun initRecycler(viewModel: ChatViewModel) {
        binding.chatRecyclerView.adapter = adapter
        getAllMessages(viewModel)
    }

    private fun getAllMessages(viewModel: ChatViewModel) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.messages
            viewModel.getAllMessages().collect {
                adapter.submitList(viewModel.filterMessagesWithoutInternet(it, userId))
            }
        }
    }

    private fun sendButtonListener(viewModel: ChatViewModel) {
        binding.sendButton.setOnClickListener {
            sendMessage(viewModel)
            clearMessageInput()
        }
    }

    private fun clearMessageInput(){
        binding.messageEditText.text?.clear()
    }

    private fun sendMessage(viewModel: ChatViewModel) {
        viewModel.sendMessage(
            binding.messageEditText.text.toString(), tag.toString(),
            requireContext().isNetworkAvailable()
        )
    }

}
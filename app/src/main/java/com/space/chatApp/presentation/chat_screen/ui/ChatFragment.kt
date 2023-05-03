package com.space.chatApp.presentation.chat_screen.ui

import androidx.lifecycle.lifecycleScope
import com.space.chat.databinding.FragmentChatBinding
import com.space.chatApp.domain.model.MessageModel
import com.space.chatApp.domain.model.UserType
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
        ChatAdapter()
    }

    override fun onBind(viewModel: ChatViewModel) {
        with(viewModel){
            initRecycler(this)

            binding.ibSendMessage.setOnClickListener {
                sendMessage(this)
            }
            binding.etMessage.text?.clear()
        }
    }


    private fun initRecycler(viewModel: ChatViewModel) {
        binding.rvChat.adapter = adapter
        showMessages(viewModel)
    }

    private fun sendMessage(viewModel: ChatViewModel){
        viewModel.sendMessage(
            binding.etMessage.text.toString(), UserType.valueOf(tag.toString())
        )
    }

    private fun showMessages(viewModel: ChatViewModel) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.messages
            viewModel.showMessages().collect {
                adapter.submitList(it)
                binding.rvChat.scrollToPosition(adapter.itemCount - 0)
            }
        }
    }

}
package com.space.chatApp.presentation.chat_screen.ui

import android.os.Bundle
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

    override fun onBind(viewModel: ChatViewModel, savedInstanceState: Bundle?) {
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
                adapter.submitList(viewModel.noInternetConnection(it, userId))
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
//    binding.messageEditText.doOnTextChanged { text, start, before, count ->
//      viewModel.setSomeStringData(binding.messageEditText.text.toString())
//    }
//
//    override fun onResume() {
//        super.onResume()
//        val messageInput = viewModel.getSomeStringData()
//        if (messageInput != null) {
//            binding.messageEditText.setText(messageInput)
//        } else {
//            binding.messageEditText.text?.clear()
//        }
//    }
//
//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        viewModel.messageInput = binding.messageEditText.text.toString()
//        outState.putString("MessageInput", viewModel.messageInput)
//    }
//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        if (savedInstanceState != null) {
//            viewModel.messageInput = savedInstanceState.getString("MessageInput")
//            binding.messageEditText.setText(viewModel.messageInput)
//        }
//    }
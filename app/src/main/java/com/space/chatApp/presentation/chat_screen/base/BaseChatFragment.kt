package com.space.chatApp.presentation.chat_screen.base

import androidx.lifecycle.lifecycleScope
import com.space.chat.R
import com.space.chat.databinding.FragmentChatBinding
import com.space.chatApp.common.extensions.isNetworkAvailable
import com.space.chatApp.common.extensions.viewBinding
import com.space.chatApp.presentation.base.AdapterListener
import com.space.chatApp.presentation.base.BaseFragment
import com.space.chatApp.presentation.chat_screen.adapter.ChatAdapter
import com.space.chatApp.presentation.chat_screen.viewModel.ChatViewModel
import kotlinx.coroutines.launch
import kotlin.reflect.KClass

// Base Chat Fragment which handles all the logic for all chat fragments
open class BaseChatFragment : BaseFragment<FragmentChatBinding, ChatViewModel>() {

    private val binding by viewBinding(FragmentChatBinding::bind)

    private val listener = object : AdapterListener {
        override fun getUserId(): String = userID()
    }

    private val adapter by lazy {
        ChatAdapter(listener)
    }

    override val layout: Int
        get() = R.layout.fragment_chat

    override val viewModelClass: KClass<ChatViewModel>
        get() = ChatViewModel::class

    override fun userID(): String = userID()

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
                adapter.submitList(viewModel.filterMessagesWithoutInternet(it, userID()))
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
            binding.messageEditText.text.toString(), userID(),
            requireContext().isNetworkAvailable()
        )
    }

}
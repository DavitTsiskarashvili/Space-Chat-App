package com.space.chatApp.presentation.chat_screen.ui

import androidx.lifecycle.lifecycleScope
import com.space.chat.databinding.FragmentChatBinding
import com.space.chatApp.common.extensions.isNetworkAvailable
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
        ChatAdapter(listener, requireContext())
    }

    override fun userId(): String {
        return tag.toString()
    }

    override fun onBind(viewModel: ChatViewModel) {
        with(viewModel) {
            initRecycler(this)

            binding.sendButton.setOnClickListener {
                if (requireContext().isNetworkAvailable()) {
                    adapter.networkType(ChatAdapter.NetworkConnection.SUCCESS)
                    sendMessage(this)
                } else {
                    adapter.networkType(ChatAdapter.NetworkConnection.ERROR)
                }
                binding.messageEditText.text?.clear()
            }
        }
    }

    private fun initRecycler(viewModel: ChatViewModel) {
        binding.chatRecyclerView.adapter = adapter
        showMessages(viewModel)
    }

    private fun sendMessage(viewModel: ChatViewModel) {
        viewModel.sendMessage(
            binding.messageEditText.text.toString(), tag.toString()
        )
    }

    private fun showMessages(viewModel: ChatViewModel) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.messages
            viewModel.showMessages().collect {
                adapter.submitList(it)
                binding.chatRecyclerView.scrollToPosition(adapter.itemCount - 1)
            }
        }
    }



//    private fun showErrorMessage(){
//        binding.tvMessage.setTextColor(resources.getColor(R.color.error_text))
//        binding.tvDate.text = resources.getText(R.string.error_message)
//    }

}
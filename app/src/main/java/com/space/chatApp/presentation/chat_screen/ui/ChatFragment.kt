package com.space.chatApp.presentation.chat_screen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
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

    private var messageInput: String? = null

    override fun onBind(viewModel: ChatViewModel, savedInstanceState: Bundle?) {
        with(viewModel) {
            initRecycler(this)
            sendButtonListener(this)
        }
    }

    private fun sendButtonListener(viewModel: ChatViewModel) {
        binding.sendButton.setOnClickListener {
            sendMessage(viewModel)
            binding.messageEditText.text?.clear()
        }
    }

    private fun initRecycler(viewModel: ChatViewModel) {
        binding.chatRecyclerView.adapter = adapter
        getAllMessages(viewModel)
    }

    private fun sendMessage(viewModel: ChatViewModel) {
        viewModel.sendMessage(
            binding.messageEditText.text.toString(), tag.toString()
        )
    }

    private fun getAllMessages(viewModel: ChatViewModel) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.messages
            viewModel.getAllMessages().collect {
                adapter.submitList(it)
            }
        }
    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        messageInput = binding.messageEditText.text.toString()
//        outState.putString("MessageInput", messageInput)
//    }
//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        if (savedInstanceState != null) {
//            messageInput = savedInstanceState.getString("editTextValue")
//            binding.messageEditText.setText(messageInput)
//        }
//    }

//    private fun showErrorMessage(){
//        binding.tvMessage.setTextColor(resources.getColor(R.color.error_text))
//        binding.tvDate.text = resources.getText(R.string.error_message)
//    }
//    adapter.networkType(ChatAdapter.NetworkConnection.SUCCESS)
//    adapter.networkType(ChatAdapter.NetworkConnection.ERROR)


}
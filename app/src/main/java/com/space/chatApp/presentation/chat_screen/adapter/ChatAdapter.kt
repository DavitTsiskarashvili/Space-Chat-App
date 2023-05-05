package com.space.chatApp.presentation.chat_screen.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.space.chat.R
import com.space.chat.databinding.LayoutMessageItemBinding
import com.space.chatApp.common.extensions.messageColor
import com.space.chatApp.common.extensions.setCustomTextColor
import com.space.chatApp.presentation.base.AdapterListener
import com.space.chatApp.presentation.chat_screen.model.MessageUiModel
import com.space.chatApp.presentation.utils.DiffUtilCallback

class ChatAdapter(private val listener: AdapterListener) :
    ListAdapter<MessageUiModel, ChatAdapter.ChatViewHolder>(DiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder =
        ChatViewHolder(
            LayoutMessageItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.onBind(getItem(position), listener)
    }

    class ChatViewHolder(private val binding: LayoutMessageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(message: MessageUiModel, listener: AdapterListener) {
            with(binding) {
                messageTextView.text = message.message
                dateTextView.text = message.time

                if (listener.getUserId() == message.sender) {

                    if (message.isNetworkConnection) {
                        root.layoutDirection = View.LAYOUT_DIRECTION_RTL
                        binding.messageTextView.setCustomTextColor(R.color.neutral_01_great_dark_grey)
                        binding.dateTextView.setCustomTextColor(R.color.neutral_02_dark_grey)
                        messageColor(
                            R.color.purple_light,
                            messageTextView,
                            bubbleImageView,
                            smallBubbleImageView
                        )
                    } else {
                        root.layoutDirection = View.LAYOUT_DIRECTION_RTL
                        binding.messageTextView.setCustomTextColor(R.color.error_text)
                        binding.dateTextView.setCustomTextColor(R.color.error_label)
                        binding.dateTextView.setText(R.string.error_message)
                    }
                } else {
                    root.layoutDirection = View.LAYOUT_DIRECTION_LTR
                    binding.messageTextView.setCustomTextColor(R.color.neutral_01_great_dark_grey)
                    binding.dateTextView.setCustomTextColor(R.color.neutral_02_dark_grey)
                    messageColor(
                        R.color.neutral_05_lightest_grey,
                        messageTextView,
                        bubbleImageView,
                        smallBubbleImageView
                    )
                }
            }
        }
    }

}
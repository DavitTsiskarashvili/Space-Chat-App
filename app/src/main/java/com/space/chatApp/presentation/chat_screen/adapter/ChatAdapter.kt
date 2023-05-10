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
import com.space.chatApp.presentation.chat_screen.model.MessageUIModel
import com.space.chatApp.presentation.utils.DiffUtilCallback

// Recycler View Adapter for chat screen
class ChatAdapter(private val listener: AdapterListener) :
    ListAdapter<MessageUIModel, ChatAdapter.ChatViewHolder>(DiffUtilCallback()) {

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

        fun onBind(message: MessageUIModel, listener: AdapterListener) {
            with(binding) {
                messageTextView.text = message.message
                dateTextView.text = message.time

                if (listener.getUserId() == message.sender) {
                    root.layoutDirection = View.LAYOUT_DIRECTION_RTL
                    messageColorForSender()
                    if (message.isNetworkConnection) {
                        textColor()
                    } else {
                        textColorWithoutInternet()
                    }
                } else {
                    root.layoutDirection = View.LAYOUT_DIRECTION_LTR
                    messageColorForReceiver()
                    textColor()
                }
            }
        }

        private fun textColor() {
            with(binding) {
                messageTextView.setCustomTextColor(R.color.neutral_01_great_dark_grey)
                dateTextView.setCustomTextColor(R.color.neutral_02_dark_grey)
            }
        }

        private fun messageColorForSender() {
            messageColor(
                R.color.purple_light,
                binding.messageTextView,
                binding.bubbleImageView,
                binding.smallBubbleImageView
            )
        }

        private fun textColorWithoutInternet() {
            with(binding) {
                messageTextView.setCustomTextColor(R.color.error_text)
                dateTextView.setCustomTextColor(R.color.error_label)
                dateTextView.setText(R.string.error_message)
            }
        }

        private fun messageColorForReceiver() {
            messageColor(
                R.color.neutral_05_lightest_grey,
                binding.messageTextView,
                binding.bubbleImageView,
                binding.smallBubbleImageView
            )
        }
    }

}
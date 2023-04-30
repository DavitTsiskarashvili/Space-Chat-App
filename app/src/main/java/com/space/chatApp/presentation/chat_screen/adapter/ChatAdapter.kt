package com.space.chatApp.presentation.chat_screen.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.space.chat.R
import com.space.chat.databinding.LayoutMessageItemBinding
import com.space.chatApp.common.extensions.DateFormat
import com.space.chatApp.common.extensions.setColor
import com.space.chatApp.domain.model.MessageModel
import com.space.chatApp.domain.model.UserType
import com.space.chatApp.presentation.utils.DiffUtilCallback

class ChatAdapter(private val user: UserType) :
    ListAdapter<MessageModel, ChatAdapter.ChatViewHolder>(DiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder =
        ChatViewHolder(
            LayoutMessageItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.onBind(getItem(position), user)
    }

    class ChatViewHolder(private val binding: LayoutMessageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(message: MessageModel, user: UserType) {
            with(binding) {
                tvMessage.text = message.message
                tvDate.text = message.time?.DateFormat()
            }
            if (message.sender == user.name) {
                binding.root.layoutDirection = View.LAYOUT_DIRECTION_RTL
                messageColor(R.color.purple_light)
            } else {
                binding.root.layoutDirection = View.LAYOUT_DIRECTION_LTR
                messageColor(R.color.neutral_05)
            }
        }

        private fun messageColor(colorRes: Int) {
            with(binding){
                tvMessage.setColor(colorRes)
                ivBubble.setColor(colorRes)
                ivSmallBubble.setColor(colorRes)
            }
        }
    }

    companion object {
        private const val Right = 1f
        private const val Left = -1f
    }

}
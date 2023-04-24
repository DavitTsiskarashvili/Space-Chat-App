package com.example.spacechatapp.presentation.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.spacechatapp.R
import com.example.spacechatapp.common.extensions.setColor
import com.example.spacechatapp.databinding.LayoutMessageItemBinding
import com.example.spacechatapp.domain.model.MessageModel
import com.example.spacechatapp.domain.model.UserType

class ChatAdapter(private val user: UserType) :
    ListAdapter<MessageModel, ChatAdapter.ChatViewHolder>(DiffUtilCallback()) {

    inner class ChatViewHolder(val binding: LayoutMessageItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder =
        ChatViewHolder(
            LayoutMessageItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ChatAdapter.ChatViewHolder, position: Int) {
        user.let {
            val message = getItem(position)
            with(holder.binding) {
                tvMessage.text = message.message
                tvDate.text = message.time
                if (user == UserType.Sender && message.isSentBySender ||
                    user == UserType.Receiver && !message.isSentBySender
                ) {
                    with(1f) {
                        tvMessage.scaleX = this
                        tvDate.scaleX = this
                        root.scaleX = this
                    }
                    with(R.color.purple_light) {
                        tvMessage.setColor(this)
                        ivBubble.setColor(this)
                        ivSmallBubble.setColor(this)
                    }
                } else {
                    with(-1f) {
                        tvMessage.scaleX = this
                        tvDate.scaleX = this
                        root.scaleX = this
                    }
                    with(R.color.neutral_05) {
                        tvMessage.setColor(this)
                        ivBubble.setColor(this)
                        ivSmallBubble.setColor(this)
                    }
                }
            }
        }
    }

    class DiffUtilCallback<T : Any> : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem == newItem
        }
    }

}
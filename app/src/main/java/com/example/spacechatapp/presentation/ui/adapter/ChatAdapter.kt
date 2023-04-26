package com.example.spacechatapp.presentation.ui.adapter

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
                tvDate.text = message.time.toString()
            }
            if (message.sender == user.name) {
                messageScaleAndColor(Right, R.color.purple_light)
            } else {
                messageScaleAndColor(Left, R.color.neutral_05)
            }
        }

        private fun messageScaleAndColor(scale: Float, colorRes: Int) {
            with(binding) {
                tvMessage.scaleX = scale
                tvDate.scaleX = scale
                root.scaleX = scale
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
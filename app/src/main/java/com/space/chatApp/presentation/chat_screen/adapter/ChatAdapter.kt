package com.space.chatApp.presentation.chat_screen.adapter

import android.view.View
import com.space.chat.R
import com.space.chat.databinding.LayoutMessageItemBinding
import com.space.chatApp.common.extensions.DateFormat
import com.space.chatApp.common.extensions.setColor
import com.space.chatApp.domain.model.MessageModel
import com.space.chatApp.domain.model.UserType
import com.space.chatApp.presentation.base.BaseAdapter

class ChatAdapter() :
    BaseAdapter<MessageModel, LayoutMessageItemBinding>(LayoutMessageItemBinding::inflate) {

    override fun onBind(binding: LayoutMessageItemBinding, position: Int) {
            val message = getItem(position)
            with(binding) {
                tvMessage.text = message.message
                tvDate.text = message.time?.DateFormat()
            }
            if (message.sender == UserType.Sender) {
                binding.root.layoutDirection = View.LAYOUT_DIRECTION_RTL
                messageColor(binding, R.color.purple_light)
            } else {
                binding.root.layoutDirection = View.LAYOUT_DIRECTION_LTR
                messageColor(binding, R.color.neutral_05)
            }
        }

    private fun messageColor(binding: LayoutMessageItemBinding, colorRes: Int) {
        with(binding) {
            tvMessage.setColor(colorRes)
            ivBubble.setColor(colorRes)
            ivSmallBubble.setColor(colorRes)
        }
    }

    companion object {
        private const val Right = 1f
        private const val Left = -1f
    }

}


package com.space.chatApp.presentation.chat_screen.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.space.chat.R
import com.space.chat.databinding.LayoutMessageItemBinding
import com.space.chatApp.common.extensions.DateFormat
import com.space.chatApp.domain.model.MessageModel
import com.space.chatApp.domain.model.UserType
import com.space.chatApp.presentation.base.BaseAdapter

class ChatAdapter(val context: Context) :
    BaseAdapter<MessageModel, LayoutMessageItemBinding>(LayoutMessageItemBinding::inflate) {

    private var isNetwork: NetworkConnection? = null

    override fun onBind(binding: LayoutMessageItemBinding, position: Int) {
        val message = getItem(position)
        with(binding) {
            messageTextView.text = message.message
            dateTextView.text = message.time?.DateFormat()
        }
        if (message.sender == UserType.Sender) {
            binding.root.layoutDirection = View.LAYOUT_DIRECTION_RTL
            messageColor(
                R.color.purple_light,
                binding.messageTextView,
                binding.bubbleImageView,
                binding.smallBubbleImageView
            )
        } else {
            binding.root.layoutDirection = View.LAYOUT_DIRECTION_LTR
            messageColor(
                R.color.neutral_05,
                binding.messageTextView,
                binding.bubbleImageView,
                binding.smallBubbleImageView
            )
        }
        if (isNetwork == NetworkConnection.SUCCESS) {
            binding.messageTextView.setTextColor(ContextCompat.getColor(context, R.color.neutral_01))
            binding.dateTextView.text = message.time?.DateFormat()
        } else {
            binding.messageTextView.setTextColor(ContextCompat.getColor(context, R.color.error_text))
            binding.dateTextView.text = (R.string.error_message.toString())
        }
    }

    private fun messageColor(colorRes: Int, vararg view: View) {
        view.forEach { view ->
            when (view) {
                is TextView -> view.setBackgroundColor(colorRes)
                is ImageView -> view.setBackgroundColor(colorRes)
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun networkType(connectionType: NetworkConnection) {
        isNetwork = connectionType
        notifyDataSetChanged()
    }

    enum class NetworkConnection() {
        SUCCESS,
        ERROR
    }

}


package com.space.chatApp.presentation.chat_screen.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.marginEnd
import com.space.chat.R
import com.space.chat.databinding.LayoutMessageItemBinding
import com.space.chatApp.common.extensions.DateFormat
import com.space.chatApp.common.extensions.setImageTint
import com.space.chatApp.common.extensions.setTextTint
import com.space.chatApp.domain.model.MessageModel
import com.space.chatApp.presentation.base.AdapterListener
import com.space.chatApp.presentation.base.BaseAdapter

class ChatAdapter(listener: AdapterListener, val context: Context) :
    BaseAdapter<MessageModel, LayoutMessageItemBinding, ChatAdapter.ChatViewHolder>(listener) {

    private var isNetwork: NetworkConnection? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder =
        ChatViewHolder(
            LayoutMessageItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    class ChatViewHolder(private val binding: LayoutMessageItemBinding) :
        BaseViewHolder<MessageModel, LayoutMessageItemBinding>(binding) {

        override fun onBind(message: MessageModel, listener: AdapterListener) {
            with(binding) {
                messageTextView.text = message.message
                dateTextView.text = message.time?.DateFormat()

                if (listener.getUserId() == message.sender) {
                    root.layoutDirection = View.LAYOUT_DIRECTION_RTL
                    messageColor(
                        R.color.purple_light,
                        messageTextView,
                        bubbleImageView,
                        smallBubbleImageView
                    )
                } else {
                    root.layoutDirection = View.LAYOUT_DIRECTION_LTR
                    messageColor(
                        R.color.neutral_05,
                        messageTextView,
                        bubbleImageView,
                        smallBubbleImageView
                    )
                }
            }
//            if (isNetwork == NetworkConnection.SUCCESS) {
//                binding.messageTextView.setTextColor(
//                    ContextCompat.getColor(
//                        context,
//                        R.color.neutral_01
//                    )
//                )
//                binding.dateTextView.text = message.time?.DateFormat()
//            } else {
//                binding.messageTextView.setTextColor(
//                    ContextCompat.getColor(
//                        context,
//                        R.color.error_text
//                    )
//                )
//                binding.dateTextView.text = (R.string.error_message.toString())
//            }
        }

        private fun messageColor(colorRes: Int, vararg view: View) {
            view.forEach { view ->
                when (view) {
                    is TextView -> view.setTextTint(colorRes)
                    is ImageView -> view.setImageTint(colorRes)
                }
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


package com.space.chatApp.presentation.chat_screen.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.space.chat.R
import com.space.chat.databinding.LayoutMessageItemBinding
import com.space.chatApp.common.extensions.DateFormat
import com.space.chatApp.common.extensions.messageColor
import com.space.chatApp.domain.model.MessageModel
import com.space.chatApp.presentation.base.AdapterListener
import com.space.chatApp.presentation.utils.DiffUtilCallback

class ChatAdapter(private val listener: AdapterListener) :
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
        holder.onBind(getItem(position), listener)
    }

    class ChatViewHolder(private val binding: LayoutMessageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(message: MessageModel, listener: AdapterListener) {
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

//    var connectionToNetwork: NetworkConnection? = null
//
//    fun network(binding: LayoutMessageItemBinding, message: MessageModel){
//        if (connectionToNetwork == NetworkConnection.SUCCESS) {
//            textColor(
//                R.color.neutral_01_great_dark_grey,
//                binding.messageTextView
//            )
//            binding.dateTextView.text = message.time?.DateFormat()
//        } else {
//            textColor(
//                R.color.error_text,
//                binding.messageTextView
//            )
//            binding.dateTextView.text = (R.string.error_message.toString())
//        }
//    }
//    private fun textColor(colorRes: Int, vararg view: View) {
//        view.forEach { view ->
//            when (view) {
//                is TextView -> view.setTextColor(colorRes)
//            }
//        }
//    }
//
//    @SuppressLint("NotifyDataSetChanged")
//    fun networkType(connectionType: NetworkConnection) {
//        connectionToNetwork = connectionType
//        notifyDataSetChanged()
//    }
//
//    enum class NetworkConnection() {
//        SUCCESS,
//        ERROR
//    }
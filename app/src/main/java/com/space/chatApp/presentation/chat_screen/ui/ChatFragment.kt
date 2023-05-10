package com.space.chatApp.presentation.chat_screen.ui

import com.space.chatApp.presentation.chat_screen.base.BaseChatFragment

// Chat Fragment which gets unique user ids
class ChatFragmentFirst : BaseChatFragment() {
    override fun userID(): String = "First"
}

class ChatFragmentSecond : BaseChatFragment() {
    override fun userID(): String = "Second"
}
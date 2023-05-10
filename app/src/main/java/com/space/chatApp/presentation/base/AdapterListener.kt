package com.space.chatApp.presentation.base

// Interface which gets used id to distinguish sender and receiver
interface AdapterListener {
    fun getUserId(): String
}
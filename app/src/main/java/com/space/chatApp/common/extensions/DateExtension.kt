package com.space.chatApp.common.extensions

import java.text.SimpleDateFormat
import java.util.*

fun Long.dateFormat(): String {
    val georgianLocale = Locale("ka", "GE")
    val dateFormat = SimpleDateFormat("MMM d,Z HH:mm", georgianLocale)
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = this
    return dateFormat.format(calendar.time)
}
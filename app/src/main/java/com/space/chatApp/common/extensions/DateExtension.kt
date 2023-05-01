package com.space.chatApp.common.extensions

import java.text.SimpleDateFormat
import java.util.*

fun Long.DateFormat(): String {
    val calendar = Calendar.getInstance()
    val dayMonthFormat = SimpleDateFormat("dd/MM, HH:mm", Locale.getDefault())
    return dayMonthFormat.format(calendar.time)
}
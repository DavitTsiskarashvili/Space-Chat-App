package com.space.chatApp.common.extensions

import android.widget.TextView
import androidx.annotation.ColorRes

fun TextView.setCustomTextColor(@ColorRes colorRes: Int) {
    this.setTextColor(context.getColor(colorRes))
}
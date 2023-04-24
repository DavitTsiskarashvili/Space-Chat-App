package com.example.spacechatapp.common.extensions

import android.content.res.ColorStateList
import android.widget.TextView

fun TextView.setColor(color: Int) {
    this.backgroundTintList = ColorStateList.valueOf(this.context.getColor(color))
}
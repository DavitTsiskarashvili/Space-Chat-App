package com.space.chatApp.common.extensions

import android.content.res.ColorStateList
import android.widget.TextView

fun TextView.setTextTint(colorRes: Int) {
    this.backgroundTintList = ColorStateList.valueOf(this.context.getColor(colorRes))
}


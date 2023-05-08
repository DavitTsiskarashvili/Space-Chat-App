package com.space.chatApp.common.extensions

import android.content.res.ColorStateList
import android.view.View
import android.widget.ImageView
import android.widget.TextView


fun ImageView.setImageTint(colorRes: Int) {
    this.backgroundTintList = ColorStateList.valueOf(this.context.getColor(colorRes))
}
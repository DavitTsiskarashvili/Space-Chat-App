package com.example.spacechatapp.common.extensions

import android.content.res.ColorStateList
import android.widget.ImageView

fun ImageView.setColor(color: Int){
    this.imageTintList = ColorStateList.valueOf(this.context.getColor(color))
}
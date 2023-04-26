package com.example.spacechatapp.common.extensions

import android.content.res.ColorStateList
import android.view.View

fun View.setColor(colorRes: Int){
    this.backgroundTintList = ColorStateList.valueOf(this.context.getColor(colorRes))
}
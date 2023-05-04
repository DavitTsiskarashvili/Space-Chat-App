package com.space.chatApp.common.extensions

import android.view.View
import android.widget.ImageView
import android.widget.TextView

fun messageColor(colorRes: Int, vararg view: View) {
    view.forEach { view ->
        when (view) {
            is TextView -> view.setTextTint(colorRes)
            is ImageView -> view.setImageTint(colorRes)
        }
    }
}
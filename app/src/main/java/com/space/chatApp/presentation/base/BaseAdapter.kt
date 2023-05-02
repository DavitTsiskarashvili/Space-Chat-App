package com.space.chatApp.presentation.base

import android.content.Context
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.space.chatApp.presentation.utils.DiffUtilCallback

abstract class BaseAdapter<T : Any, VB : ViewBinding, VH : BaseAdapter.BaseViewHolder<T, VB>>(
    private val listener: AdapterListener
) : ListAdapter<T, VH>(DiffUtilCallback<T>()) {

    interface AdapterListener {
        fun getUserId(): String
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(getItem(position), listener)
    }

    abstract class BaseViewHolder<T : Any, VB : ViewBinding>(binding: VB) :
        RecyclerView.ViewHolder(binding.root) {
        abstract fun onBind(message: T, listener: AdapterListener)
    }

}
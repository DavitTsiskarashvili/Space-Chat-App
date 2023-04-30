package com.space.chatApp.presentation.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.space.chatApp.presentation.utils.DiffUtilCallback

abstract class BaseAdapter<T : DiffUtilCallback<T>, VB : ViewBinding>(private val inflater: Inflater<VB>) :
    ListAdapter<T, BaseAdapter<T, VB>.BaseViewHolder>(DiffUtilCallback<T>()) {

    abstract fun onBind(binding: VB, position: Int)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BaseViewHolder(
        inflater.invoke(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind()
    }

    inner class BaseViewHolder(private val binding: VB) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            onBind(binding, adapterPosition)
        }
    }

}
package com.space.chatApp.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import org.koin.androidx.viewmodel.ext.android.viewModelForClass
import kotlin.reflect.KClass

typealias Inflater<T> = (inflater: LayoutInflater, view: ViewGroup?, attach: Boolean) -> T

abstract class BaseFragment<VB : ViewBinding, VM : ViewModel>() : Fragment() {

    abstract val viewModelClass: KClass<VM>
    private val viewModel: VM by viewModelForClass(clazz = viewModelClass)

    private var _binding: VB? = null
    val binding get() = _binding!!

    protected val userId get() = tag.toString()
    protected val listener = object : AdapterListener {
        override fun getUserId(): String = userId
    }

    abstract fun inflate(): Inflater<VB>
    abstract fun onBind(viewModel: VM)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = this.inflate().invoke(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBind(viewModel)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
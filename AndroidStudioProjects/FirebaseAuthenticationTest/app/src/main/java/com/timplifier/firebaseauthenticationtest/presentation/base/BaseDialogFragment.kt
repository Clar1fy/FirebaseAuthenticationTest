package com.timplifier.firebaseauthenticationtest.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.viewbinding.ViewBinding

abstract class BaseDialogFragment<Binding : ViewBinding, ViewModel : BaseViewModel>(
    @LayoutRes private val layoutId: Int
) : AppCompatDialogFragment() {

    protected abstract val binding: Binding
    protected abstract val viewModel: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        dialog?.setCancelable(false)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        return inflater.inflate(layoutId, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        assembleViews()
        initialize()
        setupListeners()
    }

    protected open fun initialize() {
    }

    protected open fun assembleViews() {

    }

    protected open fun setupListeners() {
    }
}
package com.stebakov.core.utils

import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * Created by Vladimir Stebakov on 12.07.2022
 */

private val mainHandler = Handler(Looper.getMainLooper())

fun <B : ViewBinding> Fragment.fragmentViewBinding(
    bindingCreator: (View) -> B,
) = object : ReadOnlyProperty<Fragment, B> {
    private var binding: B? = null

    override fun getValue(thisRef: Fragment, property: KProperty<*>): B {
        //view может быть null, если обращение к binding в onDestroyView
        this.binding
            ?.takeIf { view == null || it.root == view }
            ?.let { return it }

        val newBinding = bindingCreator(requireView())
        binding = newBinding
        viewLifecycleOwner.lifecycle.doOnDestroy {
            mainHandler.post {
                binding = null
            }
        }

        return newBinding
    }
}

fun Lifecycle.doOnDestroy(action: () -> Unit) {
    addObserver(object : DefaultLifecycleObserver {
        override fun onDestroy(owner: LifecycleOwner) {
            action()
        }
    })
}
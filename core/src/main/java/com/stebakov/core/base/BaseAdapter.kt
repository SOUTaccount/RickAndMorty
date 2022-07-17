package com.stebakov.core.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.stebakov.core.Comparing
import com.stebakov.core.DiffUtilCallback

/**
 * Created by Vladimir Stebakov on 13.07.2022
 */
abstract class BaseAdapter<E : Comparing<E>, T : BaseViewHolder<E>>() :
    RecyclerView.Adapter<T>() {

    protected val list = ArrayList<E>()

    fun update(new: List<E>) {
        val diffCallback = DiffUtilCallback(list, new)
        val result = DiffUtil.calculateDiff(diffCallback)
        list.clear()
        list.addAll(new)
        result.dispatchUpdatesTo(this)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: T, position: Int) = holder.bind(list[position])

    protected fun Int.makeView(parent: ViewGroup) =
        LayoutInflater.from(parent.context).inflate(this, parent, false)
}

abstract class BaseViewHolder<E>(view: View) : RecyclerView.ViewHolder(view) {
    open fun bind(item: E) {}

    class Progress<E>(view: ViewBinding) : BaseViewHolder<E>(view.root)
}
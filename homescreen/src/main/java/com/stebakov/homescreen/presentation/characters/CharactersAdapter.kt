package com.stebakov.homescreen.presentation.characters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.stebakov.core.base.BaseAdapter
import com.stebakov.core.base.BaseViewHolder
import com.stebakov.homescreen.databinding.RecyclerviewCharactersBinding
import com.stebakov.homescreen.databinding.RecyclerviewFailBinding
import com.stebakov.homescreen.databinding.RecyclerviewProgressBinding
import com.stebakov.homescreen.presentation.TryAgain
import com.stebakov.homescreen.presentation.model.CharactersDetailsUi

/**
 * Created by Vladimir Stebakov on 13.07.2022
 */
class CharactersAdapter(private val onLoadMoreItems: () -> Unit, private val tryAgain: TryAgain) :
    BaseAdapter<CharactersDetailsUi, BaseViewHolder<CharactersDetailsUi>>() {

    override fun getItemViewType(position: Int) = when (list[position]) {
        is CharactersDetailsUi.Base -> 0
        is CharactersDetailsUi.Fail -> 1
        is CharactersDetailsUi.Progress -> 2
    }

    override fun onBindViewHolder(holder: BaseViewHolder<CharactersDetailsUi>, position: Int) {
        super.onBindViewHolder(holder, position)
        if (position == list.size - 1 && list[position] is CharactersDetailsUi.Base) {
            onLoadMoreItems()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<CharactersDetailsUi> {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            0 -> CharactersViewHolder.Base(RecyclerviewCharactersBinding.inflate(layoutInflater))
            1 -> {
                val binding = RecyclerviewFailBinding.inflate(layoutInflater)
                binding.apply {
                    root.minimumHeight = parent.height
                    root.minimumWidth = parent.width
                }
                CharactersViewHolder.Fail(binding, tryAgain)
            }
            2 -> {
                val binding = RecyclerviewProgressBinding.inflate(layoutInflater)
                binding.apply {
                    root.minimumHeight = parent.height
                    root.minimumWidth = parent.width
                }
                BaseViewHolder.Progress(binding)
            }
            else -> CharactersViewHolder.Fail(
                RecyclerviewFailBinding.inflate(layoutInflater),
                tryAgain
            )
        }
    }

    abstract class CharactersViewHolder(view: View) : BaseViewHolder<CharactersDetailsUi>(view) {

        class Base(private val binding: RecyclerviewCharactersBinding) :
            CharactersViewHolder(binding.root) {
            override fun bind(item: CharactersDetailsUi) {
                with(binding) {
                    item as CharactersDetailsUi.Base
                    tvName.text = item.name()
                    tvGender.text = item.gender()
                    tvSpecies.text = item.species()
                    tvStatus.text = item.status()
                    Glide.with(itemView.context).load(item.image()).into(ivCharacter)
                }
            }
        }

        class Fail(private val binding: RecyclerviewFailBinding, private val tryAgain: TryAgain) :
            CharactersViewHolder(binding.root) {
            override fun bind(item: CharactersDetailsUi) {
                with(binding) {
                    item as CharactersDetailsUi.Fail
                    tvFail.text = item.message()
                    btnTryAgain.setOnClickListener {
                        tryAgain.retry()
                    }
                }
            }
        }
    }
}
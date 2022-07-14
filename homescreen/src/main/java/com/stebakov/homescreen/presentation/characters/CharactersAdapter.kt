package com.stebakov.homescreen.presentation.characters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.stebakov.core.base.BaseAdapter
import com.stebakov.core.base.BaseViewHolder
import com.stebakov.homescreen.databinding.RecyclerviewCharactersBinding
import com.stebakov.homescreen.presentation.model.CharactersDetailsUi

/**
 * Created by Vladimir Stebakov on 13.07.2022
 */
class CharactersAdapter() :
    BaseAdapter<CharactersDetailsUi, BaseViewHolder<CharactersDetailsUi>>() {

    override fun getItemViewType(position: Int) = when(list[position]){
        is CharactersDetailsUi.Base -> 0
        is CharactersDetailsUi.Fail -> 1
        is CharactersDetailsUi.Progress -> 2
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<CharactersDetailsUi> {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType){
            0 -> CharactersViewHolder.Base(RecyclerviewCharactersBinding.inflate(layoutInflater))
            1 -> CharactersViewHolder.Base(RecyclerviewCharactersBinding.inflate(layoutInflater))
            2 -> CharactersViewHolder.Base(RecyclerviewCharactersBinding.inflate(layoutInflater))
            else -> CharactersViewHolder.Base(RecyclerviewCharactersBinding.inflate(layoutInflater))
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
    }
}
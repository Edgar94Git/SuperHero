package com.ereyes.superhero.superHeroesModule.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.ereyes.superhero.R
import com.ereyes.superhero.common.entities.ResultSuperHero
import com.ereyes.superhero.databinding.ItemSuperHeroBinding

/****
 * Project: SuperHero
 * From: com.ereyes.superhero.superHeroesModule.adapters
 * Created by Edgar Reyes Gonzalez on 2/11/2023 at 5:33 PM
 * All rights reserved 2023.
 ****/
class SuperHeroAdapter(private var superHeroes: MutableList<ResultSuperHero>, private val listener: OnClickListener):
    RecyclerView.Adapter<SuperHeroAdapter.ViewModel>(){

    private lateinit var mContext: Context

    inner class ViewModel(view: View): RecyclerView.ViewHolder(view){
        val mBinding = ItemSuperHeroBinding.bind(view)
        fun setListener(superHero: ResultSuperHero){
            with(mBinding){
                root.setOnClickListener {
                    listener.onClick(superHero)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewModel {
        mContext = parent.context
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_super_hero, parent, false)
        return ViewModel(view)
    }

    override fun onBindViewHolder(holder: ViewModel, position: Int) {
        val superHero = superHeroes[position]
        with(holder){
            setListener(superHero)
            mBinding.tvName.text = superHero.Name
            Glide.with(mContext)
                .load(superHero.Image.Url)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(mBinding.imgSuperHero)
        }
    }

    override fun getItemCount() = superHeroes.size

    fun updateSuperHeroes(superHeroes: MutableList<ResultSuperHero>){
        this.superHeroes = superHeroes
        notifyDataSetChanged()
    }
}
package com.ereyes.superhero.superHeroesModule.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ereyes.superhero.databinding.FragmentSuperHeroesBinding

class SuperHeroesFragment : Fragment() {

    private lateinit var mBinding: FragmentSuperHeroesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragmentSuperHeroesBinding.inflate(inflater, container, false)
        return mBinding.root
    }
}
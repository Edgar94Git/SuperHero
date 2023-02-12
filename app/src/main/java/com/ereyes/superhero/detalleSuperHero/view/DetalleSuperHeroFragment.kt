package com.ereyes.superhero.detalleSuperHero.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ereyes.superhero.databinding.FragmentDetalleSuperHeroBinding

class DetalleSuperHeroFragment : Fragment() {

    private lateinit var mBinding: FragmentDetalleSuperHeroBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragmentDetalleSuperHeroBinding.inflate(inflater, container, false)
        return mBinding.root
    }
}
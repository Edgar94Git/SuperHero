package com.ereyes.superhero.detalleSuperHero.view

import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.ereyes.superhero.common.entities.Powerstats
import com.ereyes.superhero.common.entities.ResultSuperHero
import com.ereyes.superhero.common.utils.Constants
import com.ereyes.superhero.databinding.FragmentDetalleSuperHeroBinding
import com.ereyes.superhero.detalleSuperHero.viewModel.DetalleSuperHeroViewModel
import com.google.android.material.snackbar.Snackbar
import kotlin.math.roundToInt

class DetalleSuperHeroFragment : Fragment() {

    private lateinit var mBinding: FragmentDetalleSuperHeroBinding
    private lateinit var mViewModel: DetalleSuperHeroViewModel
    private var mIdSuperHero: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProvider(this)[DetalleSuperHeroViewModel::class.java]
        getSuperHeroById()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mBinding = FragmentDetalleSuperHeroBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers()
    }

    private fun getSuperHeroById() {
        arguments.let { arg ->
            mIdSuperHero = arg?.getInt(Constants.ID_SUPER_HERO) ?: 0
            mViewModel.getSuperHeroById(mIdSuperHero, Constants.ACCESS_TOKEN)
        }
    }

    private fun preparePowerStats(powerStats: Powerstats){
        with(mBinding){
            updateHeight(viewCombat, powerStats.Combat)
            updateHeight(viewDurability, powerStats.Durability)
            updateHeight(viewPower, powerStats.Power)
            updateHeight(viewSpeed, powerStats.Speed)
            updateHeight(viewIntelligence, powerStats.Intelligence)
            updateHeight(viewStrength, powerStats.Strength)
        }
    }

    private fun setUpObservers(){
        mViewModel.getSuperHero().observe(viewLifecycleOwner){ superHero ->
            prepareDetailSuperHero(superHero)
            preparePowerStats(superHero.Powerstats)
        }
        mViewModel.getSnackBarMsg().observe(viewLifecycleOwner){ msg ->
            Snackbar.make(mBinding.root, msg, Snackbar.LENGTH_LONG).show()
        }
    }

    private fun prepareDetailSuperHero(superHero: ResultSuperHero) {
        showTextView(mBinding.tvName, superHero.Name)
        showTextView(mBinding.tvFullName, superHero.Biography.FullName)
        showTextView(mBinding.tvPublisher, superHero.Biography.Publisher)
        Glide.with(this)
            .load(superHero.Image.Url)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(mBinding.imgSuperHero)
    }

    private fun showTextView(view: TextView, text: String){
        view.visibility = if(text == "" || text == "null") View.GONE else View.VISIBLE
        view.text = text
    }

    private fun updateHeight(view: View, stat: String){
        val params = view.layoutParams
        params.height = pxToD(if(stat=="null") 0f else stat.toFloat())
        view.layoutParams = params
    }

    private fun pxToD(px: Float): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, resources.displayMetrics).roundToInt()
    }
}
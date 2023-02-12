package com.ereyes.superhero.superHeroesModule.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.ereyes.superhero.common.entities.ResultSuperHero
import com.ereyes.superhero.common.utils.Constants
import com.ereyes.superhero.databinding.FragmentSuperHeroesBinding
import com.ereyes.superhero.superHeroesModule.adapters.OnClickListener
import com.ereyes.superhero.superHeroesModule.adapters.SuperHeroAdapter
import com.ereyes.superhero.superHeroesModule.viewModel.SuperHeroViewModel
import com.google.android.material.snackbar.Snackbar

class SuperHeroesFragment : Fragment(), OnClickListener {

    private lateinit var mBinding: FragmentSuperHeroesBinding
    private lateinit var mViewModel: SuperHeroViewModel
    private lateinit var mAdapter: SuperHeroAdapter
    private lateinit var mGridLayoutManager: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProvider(requireActivity())[SuperHeroViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragmentSuperHeroesBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView(mutableListOf(), 2)
        setUpObservers()
        setUpButton()
    }

    private fun setUpButton() {
        mBinding.btnSearch.setOnClickListener {
            listSuperHeroByName()
        }
    }

    private fun setUpObservers() {
        mViewModel.getSuperHeroes().observe(viewLifecycleOwner){ superHeroes ->
            mAdapter.updateSuperHeroes(superHeroes.Results as MutableList<ResultSuperHero>)
        }
        mViewModel.getSnackBarMsg().observe(viewLifecycleOwner){ msg ->
            Snackbar.make(mBinding.root, msg, Snackbar.LENGTH_LONG).show()
        }
        mViewModel.isLoaded().observe(viewLifecycleOwner){ isLoaded ->
            mBinding.progressSuperHero.visibility = if(isLoaded) View.VISIBLE else View.GONE
        }
    }

    private fun setUpRecyclerView(superHeroes: MutableList<ResultSuperHero>, columns: Int){
        mAdapter = SuperHeroAdapter(superHeroes, this)
        mGridLayoutManager = GridLayoutManager(requireActivity(),2)
        mBinding.rvSuperHero.apply {
            setHasFixedSize(true)
            layoutManager = mGridLayoutManager
            adapter = mAdapter
        }
    }

    private fun listSuperHeroByName(){
        hideKeyboard(requireActivity(), mBinding.root)
        val superHero = mBinding.tvSearch.text.toString().trim()
        mViewModel.listSuperHeroByName(superHero, Constants.ACCESS_TOKEN)
    }

    override fun onClick(superHero: ResultSuperHero) {
        Snackbar.make(mBinding.root, superHero.Biography.FullName, Snackbar.LENGTH_LONG).show()
    }

    fun hideKeyboard(context: Context, view: View){
        val imn = context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imn?.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
package com.ereyes.superhero.detalleSuperHero.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ereyes.superhero.common.entities.ResultSuperHero
import com.ereyes.superhero.common.entities.SuperHero
import com.ereyes.superhero.detalleSuperHero.model.DetalleSuperHeroRepository
import kotlinx.coroutines.launch

/****
 * Project: SuperHero
 * From: com.ereyes.superhero.detalleSuperHero.viewModel
 * Created by Edgar Reyes Gonzalez on 2/19/2023 at 1:51 PM
 * All rights reserved 2023.
 ****/
class DetalleSuperHeroViewModel: ViewModel() {

    val repository = DetalleSuperHeroRepository()

    private val superHero: MutableLiveData<ResultSuperHero> = MutableLiveData<ResultSuperHero>()
    fun getSuperHero(): MutableLiveData<ResultSuperHero> = superHero
    fun setSuperHero(superHero: ResultSuperHero){
        this.superHero.value = superHero
    }

    private val snackBarMsg: MutableLiveData<String> = MutableLiveData<String>()
    fun getSnackBarMsg(): MutableLiveData<String> = snackBarMsg

    fun getSuperHeroById(id: Int, accessToken: String){
        viewModelScope.launch {
            try {
                val result = repository.getSuperHeroBy(id, accessToken)
                superHero.value = result
            }
            catch (e: Exception){
                snackBarMsg.value = e.message
            }
        }
    }
}
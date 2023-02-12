package com.ereyes.superhero.superHeroesModule.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ereyes.superhero.common.entities.SuperHero
import com.ereyes.superhero.superHeroesModule.model.SuperHeroRepository
import kotlinx.coroutines.launch

/****
 * Project: SuperHero
 * From: com.ereyes.superhero.superHeroesModule.viewModel
 * Created by Edgar Reyes Gonzalez on 2/11/2023 at 4:13 PM
 * All rights reserved 2023.
 ****/
class SuperHeroViewModel: ViewModel() {

    private val repository = SuperHeroRepository()

    private var superHeroes: MutableLiveData<SuperHero> = MutableLiveData<SuperHero>()
    fun getSuperHeroes(): MutableLiveData<SuperHero> = superHeroes
    fun clearSuperHeroes(){
        superHeroes = MutableLiveData<SuperHero>()
    }

    private val snackBarMsg: MutableLiveData<String> = MutableLiveData<String>()
    fun getSnackBarMsg(): MutableLiveData<String> = snackBarMsg

    private val loaded: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    fun isLoaded(): MutableLiveData<Boolean> = loaded

    fun listSuperHeroByName(name: String, token: String){
        viewModelScope.launch {
            try {
                loaded.value = true
                val resultServer = repository.getSuperHeroesByName(name, token)
                superHeroes.value = resultServer
            }
            catch (e: Exception){
                snackBarMsg.value = e.message
            }
            finally {
                loaded.value = false
            }
        }
    }
}
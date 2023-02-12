package com.ereyes.superhero.superHeroesModule.model

import com.ereyes.superhero.common.dataAccess.SuperHeroService
import com.ereyes.superhero.common.entities.ResultSuperHero
import com.ereyes.superhero.common.entities.SuperHero
import com.ereyes.superhero.common.utils.Retrofit.instanceRetrofit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/****
 * Project: SuperHero
 * From: com.ereyes.superhero.superHeroesModule.model
 * Created by Edgar Reyes Gonzalez on 2/11/2023 at 4:13 PM
 * All rights reserved 2023.
 ****/
class RemoteDataBase {
    private val instance = instanceRetrofit.create(SuperHeroService::class.java)

    suspend fun getSuperHeroesByName(name: String, token: String): SuperHero = withContext(Dispatchers.IO){
        instance.getSuperHeroByName(token, name)
    }
}
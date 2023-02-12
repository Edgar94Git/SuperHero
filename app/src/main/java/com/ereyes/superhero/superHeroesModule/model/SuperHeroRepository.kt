package com.ereyes.superhero.superHeroesModule.model

import com.ereyes.superhero.common.entities.ResultSuperHero
import com.ereyes.superhero.common.entities.SuperHero

/****
 * Project: SuperHero
 * From: com.ereyes.superhero.superHeroesModule.model
 * Created by Edgar Reyes Gonzalez on 2/11/2023 at 4:12 PM
 * All rights reserved 2023.
 ****/
class SuperHeroRepository {

    private val remoteDataBase = RemoteDataBase()

    suspend fun getSuperHeroesByName(name: String, token: String): SuperHero{
        return remoteDataBase.getSuperHeroesByName(name, token)
    }
}
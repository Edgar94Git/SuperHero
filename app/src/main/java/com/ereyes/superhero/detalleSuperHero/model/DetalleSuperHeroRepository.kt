package com.ereyes.superhero.detalleSuperHero.model

import com.ereyes.superhero.common.entities.ResultSuperHero

/****
 * Project: SuperHero
 * From: com.ereyes.superhero.detalleSuperHero.model
 * Created by Edgar Reyes Gonzalez on 2/19/2023 at 3:03 PM
 * All rights reserved 2023.
 ****/
class DetalleSuperHeroRepository {

    private val remoteDataBase = RemoteDataBase()

    suspend fun getSuperHeroBy(id: Int, accessToken: String): ResultSuperHero{
        return remoteDataBase.getSuperHeroById(id, accessToken)
    }
}
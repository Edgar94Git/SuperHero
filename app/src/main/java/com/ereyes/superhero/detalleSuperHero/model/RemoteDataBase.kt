package com.ereyes.superhero.detalleSuperHero.model

import com.ereyes.superhero.common.dataAccess.SuperHeroService
import com.ereyes.superhero.common.entities.ResultSuperHero
import com.ereyes.superhero.common.entities.SuperHero
import com.ereyes.superhero.common.utils.Retrofit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/****
 * Project: SuperHero
 * From: com.ereyes.superhero.detalleSuperHero.model
 * Created by Edgar Reyes Gonzalez on 2/19/2023 at 3:01 PM
 * All rights reserved 2023.
 ****/
class RemoteDataBase {
    private val instance = Retrofit.instanceRetrofit.create(SuperHeroService::class.java)

    suspend fun getSuperHeroById(id: Int, token: String): ResultSuperHero = withContext(
        Dispatchers.IO){
        instance.getSuperHeroById(token, id)
    }
}
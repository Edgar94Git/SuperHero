package com.ereyes.superhero.common.dataAccess

import com.ereyes.superhero.common.entities.ResultSuperHero
import com.ereyes.superhero.common.entities.SuperHero
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/****
 * Project: SuperHero
 * From: com.ereyes.superhero.common.dataAccess
 * Created by Edgar Reyes Gonzalez on 2/11/2023 at 4:07 PM
 * All rights reserved 2023.
 ****/
interface SuperHeroService {

    @GET("api/{access-token}/search/{name}")
    suspend fun getSuperHeroByName(
        @Path("access-token") AccessToken: String,
        @Path("name") Name: String
    ): SuperHero
}
package com.ereyes.superhero.superHeroesModule.adapters

import com.ereyes.superhero.common.entities.ResultSuperHero

/****
 * Project: SuperHero
 * From: com.ereyes.superhero.superHeroesModule.adapters
 * Created by Edgar Reyes Gonzalez on 2/11/2023 at 5:32 PM
 * All rights reserved 2023.
 ****/
interface OnClickListener {
    fun onClick(superHero: ResultSuperHero)
}
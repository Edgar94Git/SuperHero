package com.ereyes.superhero.common.entities

import com.google.gson.annotations.SerializedName

/****
 * Project: SuperHero
 * From: com.ereyes.superhero.common.entities
 * Created by Edgar Reyes Gonzalez on 2/11/2023 at 2:01 PM
 * All rights reserved 2023.
 ****/
data class Work(
    @SerializedName("occupation") val Occupation: String,
    @SerializedName("base") val Base: String
)
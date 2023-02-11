package com.ereyes.superhero.common.entities

import com.google.gson.annotations.SerializedName

/****
 * Project: SuperHero
 * From: com.ereyes.superhero.common.entities
 * Created by Edgar Reyes Gonzalez on 2/11/2023 at 1:56 PM
 * All rights reserved 2023.
 ****/
data class Appearance(
    @SerializedName("gender") val Gender: String,
    @SerializedName("race") val Race: String,
    @SerializedName("height") val Height: List<String>,
    @SerializedName("weight") val Weight: List<String>,
    @SerializedName("eye-color") val EyeColor: String,
    @SerializedName("hair-color") val HairColor: String
)
package com.ereyes.superhero.common.entities

import com.google.gson.annotations.SerializedName

/****
 * Project: SuperHero
 * From: com.ereyes.superhero.common.entities
 * Created by Edgar Reyes Gonzalez on 2/11/2023 at 1:33 PM
 * All rights reserved 2023.
 ****/
data class Powerstats(
    @SerializedName("intelligence") val Intelligence: String,
    @SerializedName("strength") val Strength: String,
    @SerializedName("speed") val Speed: String,
    @SerializedName("durability") val Durability: String,
    @SerializedName("power") val Power: String,
    @SerializedName("combat") val Combat: String
)
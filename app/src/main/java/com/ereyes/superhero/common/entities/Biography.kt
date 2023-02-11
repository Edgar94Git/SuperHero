package com.ereyes.superhero.common.entities

import com.google.gson.annotations.SerializedName

/****
 * Project: SuperHero
 * From: com.ereyes.superhero.common.entities
 * Created by Edgar Reyes Gonzalez on 2/11/2023 at 1:44 PM
 * All rights reserved 2023.
 ****/
data class Biography(
    @SerializedName("full-name") val FullName: String,
    @SerializedName("alter-egos") val AlterEgos: String,
    @SerializedName("aliases") val Aliases: List<String>,
    @SerializedName("place-of-birth") val PlaceOfBirth: String,
    @SerializedName("first-appearance") val FirstAppearance: String,
    @SerializedName("publisher") val Publisher: String,
    @SerializedName("alignment") val Alignment: String
)
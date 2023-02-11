package com.ereyes.superhero.common.entities

import com.google.gson.annotations.SerializedName

/****
 * Project: SuperHero
 * From: com.ereyes.superhero.common.entities
 * Created by Edgar Reyes Gonzalez on 2/11/2023 at 2:09 PM
 * All rights reserved 2023.
 ****/
data class ResultSuperHero(
    @SerializedName("id") val Id: Int,
    @SerializedName("name") val Name: String,
    @SerializedName("powerstats") val Powerstats: Powerstats,
    @SerializedName("biography") val Biography: Biography,
    @SerializedName("appearance") val Appearance: Appearance,
    @SerializedName("work") val Work: Work,
    @SerializedName("connections") val Connections: Connections,
    @SerializedName("image") val Image: Image
)

package com.ereyes.superhero.common.entities

import com.google.gson.annotations.SerializedName

/****
 * Project: SuperHero
 * From: com.ereyes.superhero.common.entities
 * Created by Edgar Reyes Gonzalez on 2/11/2023 at 2:02 PM
 * All rights reserved 2023.
 ****/
data class Connections(
    @SerializedName("group-affiliation") val GroupAffiliation: String,
    @SerializedName("relatives") val Relatives: String
)

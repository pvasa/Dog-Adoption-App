package dev.priyankvasa.thegooddoggoplace.model.thedogapi

import kotlinx.serialization.Serializable

@Serializable
data class NetworkBreedWeightHeight(
    val imperial: String,
    val metric: String,
)

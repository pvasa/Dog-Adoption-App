package dev.priyankvasa.thegooddoggoplace.model.thedogapi

import kotlinx.serialization.Serializable

@Serializable
data class NetworkDoggoImage(
    val id: String,
    val url: String,
    val width: Int,
    val height: Int,
    val breeds: List<NetworkBreed>,
)

package dev.priyankvasa.thegooddoggoplace.model.thedogapi

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkBreed(
    val id: String,
    val name: String,
    val temperament: String? = null,
    @SerialName("life_span")
    val lifeSpan: String? = null,
    @SerialName("alt_names")
    val altNames: String? = null,
    @SerialName("wikipedia_url")
    val wikipediaUrl: String? = null,
    val origin: String? = null,
    @SerialName("country_code")
    val countryCode: String? = null,
    val weight: NetworkBreedWeightHeight,
    val height: NetworkBreedWeightHeight,
)

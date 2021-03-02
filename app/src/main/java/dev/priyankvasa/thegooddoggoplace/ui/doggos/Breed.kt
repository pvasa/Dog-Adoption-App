package dev.priyankvasa.thegooddoggoplace.ui.doggos

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Breed(
    val id: String,
    val name: String,
    val temperament: String?,
    val lifespan: String?,
    val altNames: String?,
    val wikipediaUrl: String?,
    val origin: String?,
    val countryCode: String?,
    val weightInMetric: String,
    val heightInMetric: String,
) : Parcelable

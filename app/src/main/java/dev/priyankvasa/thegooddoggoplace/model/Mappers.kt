package dev.priyankvasa.thegooddoggoplace.model

import dev.priyankvasa.thegooddoggoplace.model.thedogapi.NetworkBreed
import dev.priyankvasa.thegooddoggoplace.model.thedogapi.NetworkDoggoImage
import dev.priyankvasa.thegooddoggoplace.ui.NetworkUrl
import dev.priyankvasa.thegooddoggoplace.ui.doggos.Breed
import dev.priyankvasa.thegooddoggoplace.ui.doggos.DoggoImage

fun NetworkBreed.vo() = Breed(
    id,
    name,
    temperament,
    lifeSpan,
    altNames,
    wikipediaUrl,
    origin,
    countryCode,
    weight.metric,
    height.metric,
)

fun NetworkDoggoImage.vo() = DoggoImage(
    id.hashCode(),
    NetworkUrl(url),
    width,
    height,
    breeds.map { it.vo() },
)

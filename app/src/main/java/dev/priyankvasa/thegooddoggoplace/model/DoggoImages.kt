package dev.priyankvasa.thegooddoggoplace.model

import dev.priyankvasa.thegooddoggoplace.Pagination
import dev.priyankvasa.thegooddoggoplace.ui.doggos.DoggoImage

data class DoggoImages(
    val images: List<DoggoImage>,
    val pagination: Pagination,
)

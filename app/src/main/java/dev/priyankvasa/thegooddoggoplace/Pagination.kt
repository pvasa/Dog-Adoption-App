package dev.priyankvasa.thegooddoggoplace

data class Pagination(
    val page: Int,
    val limit: Int,
    val totalCount: Int = -1,
)

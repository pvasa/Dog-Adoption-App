package dev.priyankvasa.thegooddoggoplace

import kotlinx.serialization.json.Json

val JsonDefault = Json {
    isLenient = false
    ignoreUnknownKeys = false
    prettyPrint = BuildConfig.DEBUG
}

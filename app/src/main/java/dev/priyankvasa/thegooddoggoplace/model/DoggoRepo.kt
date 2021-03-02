package dev.priyankvasa.thegooddoggoplace.model

import dev.priyankvasa.thegooddoggoplace.Pagination
import dev.priyankvasa.thegooddoggoplace.model.thedogapi.NetworkDoggoImage
import dev.priyankvasa.thegooddoggoplace.network.GoodPlaceHttpClient
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class DoggoRepo private constructor(private val client: HttpClient) {
    @OptIn(ExperimentalStdlibApi::class)
    suspend fun getDoggos(page: Int = 0, limit: Int = 50): DoggoImages =
        client.get<List<NetworkDoggoImage>>("https://api.thedogapi.com/v1/images/search?order=RANDOM&page=$page&limit=$limit")
            .map { it.vo() }
            .let { doggoImages -> DoggoImages(doggoImages, Pagination(page, limit)) }

    companion object {
        private val INSTANCE = DoggoRepo(GoodPlaceHttpClient())

        operator fun invoke(): DoggoRepo = INSTANCE
    }
}

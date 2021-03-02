package dev.priyankvasa.thegooddoggoplace.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.Json
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.header

object GoodPlaceHttpClient {

    private val INSTANCE = HttpClient(Android) {
        engine {
            connectTimeout = 30_000
            socketTimeout = 30_000
        }

        Json {
            serializer = KotlinxSerializer(
                json = kotlinx.serialization.json.Json {
                    isLenient = true
                    ignoreUnknownKeys = true
                }
            )
        }

        defaultRequest {
            header("x-api-key", "e862871d-5889-4724-b788-78f1faa9d3b6")
        }
    }

    operator fun invoke(): HttpClient = INSTANCE
}

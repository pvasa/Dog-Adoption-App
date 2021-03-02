package dev.priyankvasa.thegooddoggoplace.ui.doggos

import android.os.Parcelable
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import dev.chrisbanes.accompanist.coil.CoilImage
import dev.priyankvasa.thegooddoggoplace.R
import dev.priyankvasa.thegooddoggoplace.ui.DrawableUrl
import dev.priyankvasa.thegooddoggoplace.ui.Url
import dev.priyankvasa.thegooddoggoplace.ui.doggoDetails.DoggoDetails
import kotlinx.parcelize.Parcelize

@Composable
fun DoggoCard(
    navController: NavController,
    doggoImage: DoggoImage
) {
    Card(modifier = Modifier.clickable {
        navController.currentBackStackEntry
            ?.arguments
            ?.putParcelable(DoggoDetails.navArgDoggoImage, doggoImage)
        navController.navigate(DoggoDetails.navPath)
    }
        .padding(2.dp)
        .wrapContentSize()
    ) {
        Column(modifier = Modifier.wrapContentSize()) {
            CoilImage(
                modifier = Modifier.fillMaxWidth()
                    .aspectRatio(doggoImage.width.toFloat() / doggoImage.height),
                data = doggoImage.url.value,
                contentDescription = stringResource(id = R.string.desc_doggo_image),
                fadeIn = false,
                loading = {
                    CircularProgressIndicator(Modifier.wrapContentSize())
                },
                error = {
                },
            )

            Spacer(modifier = Modifier.size(12.dp))

            Text(
                text = doggoImage.breeds.joinToString { it.name },
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
@Preview
fun DoggoCardPreview() {
    DoggoCard(
        navController = rememberNavController(),
        doggoImage = DoggoImage.PREVIEW
    )
}

@Parcelize
data class DoggoImage(
    val id: Int,
    val url: Url,
    val width: Int,
    val height: Int,
    val breeds: List<Breed>,
) : Parcelable {
    companion object {
        val PREVIEW = DoggoImage(
            Int.MAX_VALUE,
            DrawableUrl(R.drawable.ella),
            400,
            600,
            listOf(
                Breed(
                    id = "19",
                    name = "Appenzeller Sennenhund",
                    temperament = "Reliable, Fearless, Energetic, Lively, Self-assured",
                    lifespan = "12 – 14 years",
                    altNames = "",
                    wikipediaUrl = "",
                    origin = "",
                    countryCode = "",
                    weightInMetric = "22 - 25",
                    heightInMetric = "51 - 56",
                )
            )
        )
    }
}

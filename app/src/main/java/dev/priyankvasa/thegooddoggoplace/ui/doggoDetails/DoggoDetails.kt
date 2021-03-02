package dev.priyankvasa.thegooddoggoplace.ui.doggoDetails

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import dev.chrisbanes.accompanist.coil.CoilImage
import dev.priyankvasa.thegooddoggoplace.R
import dev.priyankvasa.thegooddoggoplace.ui.NavDestination
import dev.priyankvasa.thegooddoggoplace.ui.doggos.Breed
import dev.priyankvasa.thegooddoggoplace.ui.doggos.DoggoImage
import dev.priyankvasa.thegooddoggoplace.ui.theme.typography
import kotlinx.coroutines.launch

object DoggoDetails : NavDestination {
    const val navArgDoggoImage = "doggo_image"
    override val navName = "doggo_details"
    override val navPath: String = navName
}

@Composable
fun DoggoDetails(
    navController: NavController,
    doggoImage: DoggoImage
) {
    val scaffoldState: ScaffoldState = rememberScaffoldState()

    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        floatingActionButton = {
            ExtendedFloatingActionButton(
                modifier = Modifier,
                text = { Text(text = stringResource(id = R.string.text_adopt)) },
                onClick = {
                    coroutineScope.launch {
                        scaffoldState.snackbarHostState.showSnackbar(
                            "Feature coming soon.",
                            "dismiss",
                            SnackbarDuration.Short,
                        )
                    }
                },
            )
        },
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(
                        modifier = Modifier,
                        onClick = { navController.navigateUp() },
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_close_24),
                            contentDescription = stringResource(id = R.string.desc_back_button)
                        )
                    }
                },
            )
        }
    ) {
        Column(
            Modifier.fillMaxWidth()
                .wrapContentHeight()
                .verticalScroll(rememberScrollState())
        ) {
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

            BreedDetailsSection(doggoImage)
        }
    }
}

@Composable
private fun BreedDetailsSection(doggoImage: DoggoImage) {
    Column(
        modifier = Modifier.padding(12.dp)
            .padding(bottom = 80.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(
            text = stringResource(id = R.string.text_breed_details),
            style = typography.h4,
        )

        Spacer(modifier = Modifier.size(24.dp))
        doggoImage.breeds
            .firstOrNull()
            ?.let { breed -> BreedDetails(breed) }
            ?: Text(text = stringResource(id = R.string.text_no_details))
    }
}

@Composable
private fun BreedDetails(breed: Breed) {
    Text(
        text = stringResource(id = R.string.text_name),
        style = typography.body2,
    )
    Spacer(modifier = Modifier.size(4.dp))
    Text(text = breed.name, style = typography.body1)

    breed.altNames?.let { altNames ->
        Spacer(modifier = Modifier.size(24.dp))
        Text(
            text = stringResource(id = R.string.text_alt_names),
            style = typography.body2,
        )
        Spacer(modifier = Modifier.size(4.dp))
        Text(text = altNames, style = typography.body1)
    }

    breed.origin?.let { origin ->
        Spacer(modifier = Modifier.size(24.dp))

        Text(
            text = stringResource(id = R.string.text_origin),
            style = typography.body2,
        )
        Spacer(modifier = Modifier.size(4.dp))
        Text(text = origin, style = typography.body1)
    }

    breed.countryCode?.let { countryCode ->
        Spacer(modifier = Modifier.size(24.dp))

        Text(
            text = stringResource(id = R.string.text_country_code),
            style = typography.body2,
        )
        Spacer(modifier = Modifier.size(4.dp))
        Text(text = countryCode, style = typography.body1)
    }

    breed.lifespan?.let { lifespan ->
        Spacer(modifier = Modifier.size(24.dp))

        Text(
            text = stringResource(id = R.string.text_lifespan),
            style = typography.body2,
        )
        Spacer(modifier = Modifier.size(4.dp))
        Text(text = lifespan, style = typography.body1)
    }

    breed.temperament?.let { temperament ->
        Spacer(modifier = Modifier.size(24.dp))

        Text(
            text = stringResource(id = R.string.text_temperament),
            style = typography.body2,
        )
        Spacer(modifier = Modifier.size(4.dp))
        Text(text = temperament, style = typography.body1)
    }

    breed.weightInMetric.takeIf { it.isNotBlank() }?.let { weightInMetric ->
        Spacer(modifier = Modifier.size(24.dp))

        Text(
            text = stringResource(id = R.string.text_weight),
            style = typography.body2,
        )
        Spacer(modifier = Modifier.size(4.dp))
        Text(
            text = stringResource(id = R.string.weight_in_metric, weightInMetric),
            style = typography.body1,
        )
    }

    breed.heightInMetric.takeIf { it.isNotBlank() }?.let { heightInMetric ->
        Spacer(modifier = Modifier.size(24.dp))

        Text(
            text = stringResource(id = R.string.text_height),
            style = typography.body2,
        )
        Spacer(modifier = Modifier.size(4.dp))
        Text(
            text = stringResource(id = R.string.height_in_metric, heightInMetric),
            style = typography.body1,
        )
    }

    breed.wikipediaUrl?.takeIf { it.isNotBlank() }?.let { wikipediaUrl ->
        Spacer(modifier = Modifier.size(24.dp))

        Text(
            text = stringResource(id = R.string.text_more_info),
            style = typography.body2,
        )
        Spacer(modifier = Modifier.size(4.dp))
        ClickableText(
            text = AnnotatedString(wikipediaUrl),
            onClick = {
            },
        )
    }
}

@Composable
@Preview
fun DoggoDetailsPreview() {
    DoggoDetails(navController = rememberNavController(), doggoImage = DoggoImage.PREVIEW)
}

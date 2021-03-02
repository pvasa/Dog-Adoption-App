package dev.priyankvasa.thegooddoggoplace

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import dev.priyankvasa.thegooddoggoplace.ui.Welcome
import dev.priyankvasa.thegooddoggoplace.ui.doggoDetails.DoggoDetails
import dev.priyankvasa.thegooddoggoplace.ui.doggos.DoggoImage
import dev.priyankvasa.thegooddoggoplace.ui.doggos.Doggos
import dev.priyankvasa.thegooddoggoplace.ui.theme.TheGoodDoggoPlaceTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Content()
        }
    }
}

@Composable
@Preview
fun Content() {
    val navController = rememberNavController()

    TheGoodDoggoPlaceTheme {
        NavHost(navController, startDestination = Welcome.navPath) {
            composable(Welcome.navPath) { Welcome(navController) }
            composable(Doggos.navPath) { Doggos(navController) }
            composable(
                DoggoDetails.navPath,
                arguments = listOf(navArgument(DoggoDetails.navArgDoggoImage) {
                    type = NavType.ParcelableType(DoggoImage::class.java)
                })
            ) {
                DoggoDetails(
                    navController,
                    navController.previousBackStackEntry!!.arguments!!.getParcelable(
                        DoggoDetails.navArgDoggoImage
                    )!!
                )
            }
        }
    }
}

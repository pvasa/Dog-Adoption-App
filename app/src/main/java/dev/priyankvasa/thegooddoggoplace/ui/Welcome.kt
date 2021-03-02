@file:OptIn(ExperimentalTime::class)

package dev.priyankvasa.thegooddoggoplace.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.popUpTo
import dev.priyankvasa.thegooddoggoplace.R
import dev.priyankvasa.thegooddoggoplace.ui.doggos.Doggos
import dev.priyankvasa.thegooddoggoplace.ui.theme.typography
import kotlin.time.ExperimentalTime
import kotlin.time.seconds
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

object Welcome : NavDestination {
    override val navName: String = "welcome"
    override val navPath: String = navName
}

private val WELCOME_DELAY = 2.seconds

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Welcome(
    navController: NavController,
) {
    val coroutineScope = rememberCoroutineScope()

    Surface {
        Box(
            Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = stringResource(id = R.string.title_welcome),
                style = typography.h4,
                textAlign = TextAlign.Center,
            )
        }
    }

    coroutineScope.launch {
        delay(WELCOME_DELAY)

        navController.navigate(Doggos.navPath) {
            popUpTo(Welcome.navPath) {
                inclusive = true
            }
        }
    }
}

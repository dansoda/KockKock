package kr.duckcade.kockkock.ui.onborading

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kr.duckcade.kockkock.ui.utils.Screen

@Composable
fun OnBoardingScreen(
    navController: NavController,
    dispatcher: CoroutineDispatcher = Dispatchers.Main
) {
    navController.navigate(Screen.MapScreen.route)
}
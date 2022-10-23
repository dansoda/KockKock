package kr.duckcade.kockkock.ui.utils

sealed class Screen(val route: String) {
    object SplashScreen : Screen("splash_screen")
    object OnBoardingScreen : Screen("onboarding_screen")
    object LoginScreen : Screen("login_screen")
    object MapScreen : Screen("map_screen")
    object SearchScreen : Screen("search_screen")
    object ProfileScreen : Screen("profile_screen")
}

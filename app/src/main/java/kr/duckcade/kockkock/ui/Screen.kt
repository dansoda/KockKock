package kr.duckcade.kockkock.ui

sealed class Screen(val route: String) {
    object SplashScreen : Screen("splash_screen")
    object OnBoardingScreen : Screen("onboarding_screen")
}

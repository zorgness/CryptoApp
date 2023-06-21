package com.example.cryptoapp.utils

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Main : Screen("main")
    object Login : Screen("login")
    object Register : Screen("register")
}
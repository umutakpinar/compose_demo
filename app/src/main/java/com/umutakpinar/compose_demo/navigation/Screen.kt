package com.umutakpinar.compose_demo.navigation

sealed class Screen(val route: String){
    object Home : Screen(route = "first_screen")
    object Recomposition : Screen(route = "recomposition_screen")
}

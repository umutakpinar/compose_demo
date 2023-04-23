package com.umutakpinar.compose_demo.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.umutakpinar.compose_demo.navigation.Screen

@Composable
fun RecompositionScreen(
    navController: NavHostController
){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.clickable {
                navController.popBackStack()
                /*navController.navigate(Screen.Home.route){
                    popUpTo(Screen.Home.route){
                        inclusive = true
                    }
                }*/
            }
        ) {
            Text(text = "2",
                color = MaterialTheme.colors.primary,
                fontSize = MaterialTheme.typography.h1.fontSize,
                fontWeight = FontWeight.Bold
            )
            Text(text = "Second Screen",
                color = MaterialTheme.colors.primary,
                fontSize = MaterialTheme.typography.h2.fontSize,
                fontWeight = FontWeight.Bold
                )
            Text(text = "click to go first")
        }
    }
}

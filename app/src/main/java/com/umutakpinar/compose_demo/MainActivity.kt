package com.umutakpinar.compose_demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.umutakpinar.compose_demo.navigation.SetupNavGraph
import com.umutakpinar.compose_demo.ui.theme.Compose_demoTheme

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_demoTheme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}


/*
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
    
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Compose_demoTheme {
        Greeting("Android")
    }
}
*/
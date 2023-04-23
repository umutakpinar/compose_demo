package com.umutakpinar.compose_demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.currentRecomposeScope
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.umutakpinar.compose_demo.navigation.Screen
import com.umutakpinar.compose_demo.navigation.SetupNavGraph
import com.umutakpinar.compose_demo.ui.theme.Compose_demoTheme

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_demoTheme {
                navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()
                MainScreen(navController = navController, scaffoldState)
            }
        }
    }
}

@Composable
fun MainScreen(
    navController: NavHostController,
    scaffoldState: ScaffoldState,
) {
    //Taking currentBackStackEntry as state so we can observe the changes
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.background
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ){
                        if (currentRoute != Screen.Home.route) {
                            IconButton(
                                modifier = Modifier.align(Alignment.CenterStart),
                                onClick = {
                                navController.popBackStack()
                            }) {
                                Icon(
                                    imageVector = Icons.Outlined.ArrowBack,
                                    contentDescription = "Go back"
                                )
                            }
                        }
                        Text(
                            modifier = Modifier.align(Alignment.Center),
                            text = "Header"
                        )
                    }
                }

            }
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            SetupNavGraph(navController = navController)
        }
    }
}

//preview
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Compose_demoTheme {
        val navController = rememberNavController()
        val canPop = remember {
            mutableStateOf(false)
        }
        val scaffoldState = rememberScaffoldState()
        MainScreen(
            navController = rememberNavController(),
            scaffoldState = scaffoldState
        )
    }
}

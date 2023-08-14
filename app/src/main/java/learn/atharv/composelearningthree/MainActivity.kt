package learn.atharv.composelearningthree

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import learn.atharv.composelearningthree.ui.theme.ComposeLearningThreeTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLearningThreeTheme {
                MainScreen()
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MainScreen() {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        val navController = rememberNavController()

        // code for drawer
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet {
                    Column {
                        DrawerHeader()
                        DrawerBody(items = listOf(
                            MenuItem(
                                id = DrawerScreens.Home.route,
                                title = "Home",
                                contentDescription = "Go to home screen",
                                icon = Icons.Default.Home
                            ),
                            MenuItem(
                                id = DrawerScreens.Account.route,
                                title = "Settings",
                                contentDescription = "Go to settings screen",
                                icon = Icons.Default.Settings
                            ),
                            MenuItem(
                                id = DrawerScreens.Help.route,
                                title = "Help",
                                contentDescription = "Get help",
                                icon = Icons.Default.Info
                            ),
                        ), onItemClick = {
                            navController.navigate(it.id)
                            scope.launch {
                                drawerState.apply {
                                    if (isClosed) open() else close()
                                }
                            }
                        })
                    }
                }
            },
        ) {
            // This is main screen where which conttent should placed
            Scaffold(floatingActionButton = {
                ExtendedFloatingActionButton(text = { Text("Show drawer") },
                    icon = { Icon(Icons.Filled.Add, contentDescription = "") },
                    onClick = {
                        scope.launch {
                            drawerState.apply {
                                if (isClosed) open() else close()
                            }
                        }
                    })
            }) { contentPadding ->
                // Screen content
                contentPadding
                NavHost(
                    navController = navController,
                    startDestination = DrawerScreens.Home.route
                ) {
                    composable(DrawerScreens.Home.route) {
                        Home()
                    }
                    composable(DrawerScreens.Account.route) {
                        Account()
                    }
                    composable(DrawerScreens.Help.route) {
                        Help(
                            navController = navController
                        )
                    }
                }
            }
        }
    }

}


//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ComposeLearningThreeTheme {
//    }
//}
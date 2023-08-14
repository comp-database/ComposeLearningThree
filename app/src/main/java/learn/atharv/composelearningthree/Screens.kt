package learn.atharv.composelearningthree

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun Home() {
    Column(modifier = Modifier.fillMaxSize()) {
//        TopBar(
//            title = "Home",
//            buttonIcon = Icons.Filled.Menu,
//            onButtonClicked = { openDrawer() }
//        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Home Page content here.")
        }
    }
}

@Composable
fun Account() {
    Column(modifier = Modifier.fillMaxSize()) {
//        TopBar(
//            title = "Account",
//            buttonIcon = Icons.Filled.Menu,
//            onButtonClicked = { openDrawer() }
//        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Account.", style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Composable
fun Help(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
//        TopBar(
//            title = "Help",
//            buttonIcon = Icons.Filled.ArrowBack,
//            onButtonClicked = { navController.popBackStack() }
//        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Help.", style = MaterialTheme.typography.bodyLarge)
        }
    }
}
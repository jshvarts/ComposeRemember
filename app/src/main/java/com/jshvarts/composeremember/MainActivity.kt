package com.jshvarts.composeremember

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentRecomposeScope
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jshvarts.composeremember.ui.theme.ComposeRememberTheme

private val FRUITS = listOf(
    "apple",
    "tomato",
    "banana"
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeRememberTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreenRememberMutableState()
                }
            }
        }
    }
}

@Composable
fun MainScreenRemember() {

    println("currentRecomposeScope $currentRecomposeScope")

    var randomFruit = remember { FRUITS.random() }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        println("currentRecomposeScope $currentRecomposeScope")

        Button(
            modifier = Modifier
                .width(100.dp),
            onClick = { randomFruit = FRUITS.random() }
        ) {

            println("currentRecomposeScope $currentRecomposeScope")

            Text(randomFruit)
        }
    }
}

@Composable
fun MainScreenRememberMutableState() {
    println("currentRecomposeScope $currentRecomposeScope")

    var randomFruit by remember { mutableStateOf(FRUITS.random()) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        println("currentRecomposeScope $currentRecomposeScope")

        Button(
            modifier = Modifier
                .width(100.dp),
            onClick = { randomFruit = FRUITS.random() }
        ) {

            println("currentRecomposeScope $currentRecomposeScope")

            Text(randomFruit)
        }
    }
}
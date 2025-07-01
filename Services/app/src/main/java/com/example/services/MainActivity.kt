package com.example.services

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.services.ui.theme.ServicesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ServicesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting()
//                    ForegroundServiceUi()
                    dropDownMenuUI()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    val context= LocalContext.current
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Button(
            onClick = {
                context.startService(Intent(context,AppServices::class.java))
            },

        ) {
            Text(text = "Start Service")

        }
    }
}

@Composable
fun ForegroundServiceUi() {
    val context= LocalContext.current
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Button(
            onClick = {
                context.startForegroundService(Intent(context, ForegroundService::class.java))
            },

            ) {
            Text(text = "Start Service")

        }
    }
}



@Composable
fun dropDownMenuUI(){
    var name= remember { mutableStateOf("") }
    var dropDown= remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        OutlinedTextField(
            value = name.value,
            onValueChange = { name.value = it },
            label = { Text("Name") },
            trailingIcon = {
                IconButton(
                    onClick = {
                        dropDown.value = true
                    }
                ) {
                    Icon(
                        Icons.Default.ArrowDropDown,
                        null
                    )
                }

                DropdownMenu(
                    expanded = dropDown.value,
                    onDismissRequest = {
                        dropDown.value = false
                    },
                    modifier = Modifier.fillMaxWidth(),
                    scrollState = rememberScrollState()
                ) {

                    for(i in 1..3){
                        DropdownMenuItem(
                            text = { Text("Item $i") },
                            onClick = {
                                name.value = "Item $i"
                            }
                        )
                    }

                }

            }
        )

    }

}
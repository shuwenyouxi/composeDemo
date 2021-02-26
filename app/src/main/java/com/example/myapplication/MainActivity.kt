package com.example.myapplication

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val count = remember { mutableStateOf(0) }
                    Column(modifier = Modifier.fillMaxHeight()) {
                        NameList(List(100) { "wakaka" }, Modifier.weight(1F))
                        Button(onClick = { count.value++ }) {
                            Text("aaaaaa ${count.value}")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    MaterialTheme {
        val typography = MaterialTheme.typography
        var isSelected by remember { mutableStateOf(false) }
        val bgColor by animateColorAsState(if (isSelected) Color.Red else Color.Transparent)
        Surface(color = Color.White) {
            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Text("Hello $name!",
                    style = typography.h6,
                    modifier = Modifier
                        .padding(10.dp)
                        .background(color = bgColor)
                        .clickable(onClick = { isSelected = !isSelected })
                )
                Divider(color = Color.Green)
                Text(
                    "wakakwakakawakakawakakawakakawakakawakakawakakawakakawakakawakakawakakawakakawakakawakakawakakawakakaa",
                    style = typography.body2,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
fun NameList(nameList: List<String>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(items = nameList) { name ->
            Greeting(name = name)
            Divider()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        val count = remember { mutableStateOf(0) }
        Column(modifier = Modifier.fillMaxHeight()) {
            NameList(List(100) { "wakaka" }, Modifier.weight(1F))
            Button(onClick = { count.value++ }) {
                Text("aaaaaa ${count.value}")
            }
        }
    }
}
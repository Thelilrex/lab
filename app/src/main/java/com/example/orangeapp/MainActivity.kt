package com.example.orangeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.orangeapp.ui.theme.OrangeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OrangeAppTheme {
                tapTheScreen()
            }
        }
    }
}

@Composable
fun tapTheScreen (modifier:Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center))
{
    var count by remember { mutableStateOf(0)}
    var result by remember { mutableStateOf(0)}
    var ImageId by remember { mutableStateOf(1)}
    var taps by remember { mutableStateOf(0)}
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally)
    {
        var ImageID: Int = when(ImageId)
        {
            1 -> R.drawable.orange_tree
            2 -> R.drawable.orange_fruit
            3 -> R.drawable.orange_drink_full
            else -> R.drawable.orange_drink_empty
        }

        Spacer(modifier = Modifier.height(100.dp))
        Button(
            onClick = {
            if(ImageId == 2)
            {
                result = (5 .. 10).random()
                if(taps < result)
                {
                    taps += 1
                }
                else
                {
                    ImageId++
                }
            }
            else if(ImageId == 4)
            {
                ImageId = 1
                count++
            }
            else
            {
                ImageId++
            }

        }) {
            Image(painter = painterResource(id = ImageID), contentDescription = "Orange")
            when (ImageId) {
                1 -> Text(text = stringResource(id = R.string.ButtonTree))
                2 -> Text(text = stringResource(id = R.string.ButtonOrange))
                3 -> Text(text = stringResource(id = R.string.ButtonDrink))
                else -> Text(text = stringResource(id = R.string.ButtonEmpty))
            }

        }
        Text(text = "Game Count = $count")
    }
}

@Preview(showBackground = true)
@Composable
fun tapTheScreenPreview()
{
    tapTheScreen()
}
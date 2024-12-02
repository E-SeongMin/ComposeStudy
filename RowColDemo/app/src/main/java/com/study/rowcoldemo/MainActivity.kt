package com.study.rowcoldemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.study.rowcoldemo.ui.theme.RowColDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RowColDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun TextCell(text: String, modifier: Modifier = Modifier) {
    val cellModifier = modifier
        .padding(4.dp)
        .size(100.dp, 100.dp)
        .border(width = 4.dp, color = Color.Black)

    Text(text = text,
        cellModifier.then(modifier),
        fontSize = 70.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center)
}

@Preview
@Composable
fun MainScreen() {
    Column {
        Row {
            TextCell(text = "1", Modifier.weight(weight = 0.2f, fill = true))
            TextCell(text = "2", Modifier.weight(weight = 0.4f, fill = true))
            TextCell(text = "3", Modifier.weight(weight = 0.3f, fill = true))
        }

        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.size(width = 400.dp, height = 200.dp)) {
            Column {
                TextCell(text = "4")
            }

            Column {
                TextCell(text = "5")
                TextCell(text = "6")
            }
        }

        Row {
            TextCell(text = "7")
            TextCell(text = "8")
            TextCell(text = "9")
        }

        Row {
            Text(
                text = "Large Text\nMore Text",
                Modifier.alignBy(LastBaseline),
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Small Text",
                Modifier.paddingFrom(
                    alignmentLine = FirstBaseline,
                    before = 80.dp,
                    after = 0.dp
                ),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
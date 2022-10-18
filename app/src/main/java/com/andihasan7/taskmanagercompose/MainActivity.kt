package com.andihasan7.taskmanagercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andihasan7.taskmanagercompose.ui.theme.TaskManagerComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    ImageTask(title = getString(R.string.title), subTitle = getString(R.string.sub_title))
                }
            }
        }
    }
}

@Composable
fun ImageTask(title: String, subTitle: String) {
    val image = painterResource(id = R.drawable.ic_task_completed)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = image, contentDescription = null,
            modifier = Modifier
                .height(200.dp)
                .width(200.dp)
        )
        TitleText(title = title, subTitle = subTitle)
    }

}

@Composable
fun TitleText(title: String, subTitle: String) {
    Column() {
        Text(text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(top = 24.dp, bottom = 8.dp)
        )
        
        Text(text = subTitle,
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TaskManagerPreview() {
    TaskManagerComposeTheme {
        ImageTask(title = "hello", subTitle = "kotlin")
    }
}
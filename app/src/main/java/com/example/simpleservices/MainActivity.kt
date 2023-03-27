package com.example.simpleservices

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkRequest
import com.example.simpleservices.ui.theme.SimpleServicesTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleServicesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Service()

                }
            }
        }
    }
}

@Composable
fun Service() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            //your onclick code here

            val intent = Intent(context, Services::class.java)
            context.startService(intent)

        }) {
            Text(text = "Start Service")
        }
        Button(onClick = {
            //your onclick code here
            val myWorkRequest:WorkRequest = OneTimeWorkRequest.Builder(WorkManager::class.java)
                .build()

            androidx.work.WorkManager.getInstance(context).enqueue(myWorkRequest)
        }) {
            Text(text = "Work Manager Service")
        }
        Button(onClick = {
            //your onclick code here
            val intent = Intent(context, Services::class.java)
            context.stopService(intent)
        }) {
            Text(text = "Stop Service")
        }


    }
}


@Preview(showBackground = true)
@Composable
fun ServicePreview() {
    SimpleServicesTheme {
        Service()
    }
}
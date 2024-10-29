package com.example.devsmenu

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.devsmenu.ui.theme.DevsMenuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DevsMenuTheme {
                MainScreen()
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MainScreen() {

    val oxaniumFontFamily = FontFamily(
        Font(R.font.oxanium_regular)
    )
    val context = LocalContext.current



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff161616)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "DEVS",
            color = Color.White,
            fontSize = 80.sp,
            modifier = Modifier
                .padding(start = 30.dp)
                .align(Alignment.Start),
            fontFamily = oxaniumFontFamily,
        )
        Text(
            "MENU",
            color = Color.White,
            fontSize = 80.sp,
            modifier = Modifier
                .padding(start = 30.dp)
                .align(Alignment.Start),
            fontFamily = oxaniumFontFamily
        )
        Spacer(Modifier.height(300.dp))
        Button(
            onClick = { openDeveloperOptions(context) },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(
                    start = 32.dp,
                    end = 32.dp
                ),

            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xff2d2d2d))
        ) {
            Text(
                "Open Developer Settings", style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,

                    )
            )
        }
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = { turnOnDeveloperOptions(context) },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(
                    start = 32.dp,
                    end = 32.dp
                ),
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xff2d2d2d))
        ) {
            Text(
                "Turn on Developer Settings", style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,

                    )
            )
        }
    }

}


fun openDeveloperOptions(context: Context) {
    val intent = Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS)
    context.startActivity(intent)
}

fun turnOnDeveloperOptions(context: Context) {
    val intent = Intent(Settings.ACTION_DEVICE_INFO_SETTINGS)
    context.startActivity(intent)
}


package com.example.greenlife.ui.theme.screens.splash

import android.annotation.SuppressLint
import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.greenlife.R
import com.example.greenlife.navigation.ROUT_LOGIN
import com.example.greenlife.ui.theme.green
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreen(navController: NavController){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = green),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){

        var coroutineScope = rememberCoroutineScope()
        coroutineScope.launch {
            delay(3000)
            navController.navigate(ROUT_LOGIN)

        }

        val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.leafanimation))
        val progress by animateLottieCompositionAsState(composition)
        LottieAnimation(composition, progress,
            modifier = Modifier.size(300.dp) )

        Text(
            text = "GreenLife",
            fontSize = 40.sp,
            fontFamily = FontFamily.Cursive,
        )

        Spacer(modifier = Modifier.height(10.dp))


        Text(
            text = "We Grow Together",
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive,
        )


    }

}

@Composable
@Preview(showBackground = true)
fun SplashScreenScreenPreview(){
    SplashScreen(rememberNavController())}

package com.example.greenlife.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.greenlife.ui.theme.screens.login.LoginScreen
import com.example.greenlife.ui.theme.screens.about.AboutScreen
import com.example.greenlife.ui.theme.screens.climate.ClimateScreen
import com.example.greenlife.ui.theme.screens.croptype.CroptypeScreen
import com.example.greenlife.ui.theme.screens.fruits.FruitsScreen
import com.example.greenlife.ui.theme.screens.grains.GrainsScreen
import com.example.greenlife.ui.theme.screens.home.HomeScreen
import com.example.greenlife.ui.theme.screens.shop.ShopScreen
import com.example.greenlife.ui.theme.screens.signup.SignupScreen
import com.example.greenlife.ui.theme.screens.soiltype.SoiltypeScreen
import com.example.greenlife.ui.theme.screens.splash.SplashScreen
import com.example.greenlife.ui.theme.screens.vegetables.VegetablesScreenPreview
import com.example.greenlife.ui.theme.screens.vegetables.VegetablesScreen
import com.example.property.ui.theme.screens.products.AddCropScreen
import com.example.property.ui.theme.screens.products.ViewCropScreen


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination:String = ROUT_SPLASH
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {


        composable(ROUT_ABOUT){
            AboutScreen(navController = navController)
        }

        composable(ROUT_SPLASH){
            SplashScreen(navController = navController)
        }


        composable(ROUT_SIGNUP){
            SignupScreen(navController = navController)
        }

        composable(ROUT_LOGIN){
            LoginScreen(navController = navController)
        }

        composable(ROUT_HOME){
            HomeScreen(navController = navController)
        }

        composable(ROUT_SOILTYPE){
            SoiltypeScreen(navController = navController)
        }

        composable(ROUT_CROPTYPE){
            CroptypeScreen(navController = navController)
        }

        composable(ROUT_CLIMATE){
            ClimateScreen(navController = navController)
        }


        composable(ROUT_ADDCROP){
            AddCropScreen(navController = navController)
        }

        composable(ROUT_VIEWCROP){
            ViewCropScreen(navController = navController)
        }

        composable(ROUT_VEGETABLES){
            VegetablesScreen(navController = navController)
        }

        composable(ROUT_FRUITS){
            FruitsScreen(navController = navController)
        }

        composable(ROUT_GRAINS){
            GrainsScreen(navController = navController)
        }

        composable(ROUT_SHOP){
            ShopScreen(navController = navController)
        }




    }
}
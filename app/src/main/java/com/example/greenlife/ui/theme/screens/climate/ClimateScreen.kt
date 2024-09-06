package com.example.greenlife.ui.theme.screens.climate

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.greenlife.R
import com.example.greenlife.ui.theme.green


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ClimateScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        var selected by remember { mutableIntStateOf(0) }
        Scaffold (
            bottomBar = {
                NavigationBar(
                    containerColor = green,
                    contentColor = Color.Gray
                ) {
                    bottomNavItems.forEachIndexed { index, bottomNavItem ->
                        NavigationBarItem(
                            selected = index == selected,
                            onClick = {
                                selected = index
                                navController.navigate(bottomNavItem.route)
                            },
                            icon = {
                                BadgedBox(
                                    badge = {
                                        if (bottomNavItem.badges != 0) {
                                            Badge {
                                                Text(text = bottomNavItem.badges.toString())
                                            }
                                        } else if (bottomNavItem.hasNews) {
                                            Badge()
                                        }
                                    }
                                ) {
                                    Icon(imageVector =
                                    if (index == selected)
                                        bottomNavItem.selectedIcon
                                    else
                                        bottomNavItem.unselectedIcon,
                                        contentDescription = bottomNavItem.title)
                                }

                            },
                            label = {
                                Text(text = bottomNavItem.title)
                            })
                    }
                }
            },

            topBar = {
                TopAppBar(
                    title = { Text(text = "GreenLife") },
                    colors = TopAppBarDefaults.mediumTopAppBarColors(green))
            },



            //Content Section
            content = @Composable {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 70.dp, bottom = 100.dp)
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally

                ){
                    Spacer(modifier = Modifier.height(30.dp))

                    Text(
                        text = "Climates",
                        fontSize = 30.sp,
                        fontFamily = FontFamily.Cursive,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(30.dp))

                    //Tropical climate
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 10.dp),

                        ){

                        Box(modifier = Modifier
                            .height(200.dp)
                            .fillMaxWidth(),
                            contentAlignment = Alignment.Center) {

                            Card {
                                Image(painter = painterResource(id = R.drawable.tropicalclimate),
                                    contentDescription = "tropicalclimate",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop)

                            }
                        }
                        Spacer(modifier = Modifier.height(10.dp))


                        Text(
                            text = "Tropical (Coastal Regions)",
                            fontSize = 25.sp,
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Center,

                            )
                        Text(text = "Temperatures : 24 - 30 degrees", textAlign = TextAlign.Right)
                        Text(text = "Rainfall : 1000mm - 1200mm", textAlign = TextAlign.Right)
                        Text(text = "Hot and humid year round", textAlign = TextAlign.Right)

                        Spacer(modifier = Modifier.height(50.dp))

                    }

                    //Temprate climate
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 10.dp),

                        ){

                        Box(modifier = Modifier
                            .height(200.dp)
                            .fillMaxWidth(),
                            contentAlignment = Alignment.Center) {

                            Card {
                                Image(painter = painterResource(id = R.drawable.temprateclimate),
                                    contentDescription = "temprateclimate",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop)

                            }
                        }
                        Spacer(modifier = Modifier.height(10.dp))


                        Text(
                            text = "Temprate (Central highlands)",
                            fontSize = 25.sp,
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Center,

                            )
                        Text(text = "Temperatures : 10 - 26 degrees", textAlign = TextAlign.Right)
                        Text(text = "Rainfall : 800mm - 2000mm", textAlign = TextAlign.Right)
                        Text(text = "Mild and cool temperatures are due to higher altitudes", textAlign = TextAlign.Right)

                        Spacer(modifier = Modifier.height(50.dp))

                    }

                    //Arid climate
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 10.dp),

                        ){

                        Box(modifier = Modifier
                            .height(200.dp)
                            .fillMaxWidth(),
                            contentAlignment = Alignment.Center) {

                            Card {
                                Image(painter = painterResource(id = R.drawable.semiaridclimate),
                                    contentDescription = "semiaridclimate",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop)

                            }
                        }
                        Spacer(modifier = Modifier.height(10.dp))


                        Text(
                            text = "Arid and Semi-arid",
                            fontSize = 25.sp,
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Center,

                            )
                        Text(text = "Temperatures : Above 35 degrees", textAlign = TextAlign.Right)
                        Text(text = "Rainfall : 250mm - 500mm", textAlign = TextAlign.Right)
                        Text(text = "Hot and dry with minimal rainfall", textAlign = TextAlign.Right)

                        Spacer(modifier = Modifier.height(50.dp))

                    }

                    //Equitorial climate
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 10.dp),

                        ){

                        Box(modifier = Modifier
                            .height(200.dp)
                            .fillMaxWidth(),
                            contentAlignment = Alignment.Center) {

                            Card {
                                Image(painter = painterResource(id = R.drawable.equitorialclimate),
                                    contentDescription = "equitorialclimate",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop)

                            }
                        }
                        Spacer(modifier = Modifier.height(10.dp))


                        Text(
                            text = "Equatorial (Western Kenya)",
                            fontSize = 25.sp,
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Center,

                            )
                        Text(text = "Temperatures : 20 - 28 degrees", textAlign = TextAlign.Right)
                        Text(text = "Rainfall : 1000mm - 2000mm", textAlign = TextAlign.Right)
                        Text(text = "Warm with high rainfall", textAlign = TextAlign.Right)

                        Spacer(modifier = Modifier.height(50.dp))

                    }

                    //Highland climate
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 10.dp),

                        ){

                        Box(modifier = Modifier
                            .height(200.dp)
                            .fillMaxWidth(),
                            contentAlignment = Alignment.Center) {

                            Card {
                                Image(painter = painterResource(id = R.drawable.highlandclimate),
                                    contentDescription = "highlandclimate",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop)

                            }
                        }
                        Spacer(modifier = Modifier.height(10.dp))


                        Text(
                            text = "Highland (Mt Kenya Region)",
                            fontSize = 25.sp,
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Center,

                            )
                        Text(text = "Temperatures : 10 - 22 degrees", textAlign = TextAlign.Right)
                        Text(text = "Rainfall : 1500mm - 3000mm", textAlign = TextAlign.Right)
                        Text(text = "Cool temperatures with some areas experiencing frost", textAlign = TextAlign.Right)

                        Spacer(modifier = Modifier.height(50.dp))

                    }


                }

            }
        )





    }

}
val bottomNavItems = listOf(
    BottomNavItem(
        title = "Home",
        route="home",
        selectedIcon= Icons.Filled.Home,
        unselectedIcon= Icons.Outlined.Home,
        hasNews = false,
        badges=0
    ),



    BottomNavItem(
        title = "About",
        route="about",
        selectedIcon= Icons.Filled.Info,
        unselectedIcon= Icons.Outlined.Info,
        hasNews = true,
        badges=0
    ),

    BottomNavItem(
        title = "Shop",
        route="property",
        selectedIcon= Icons.Filled.ShoppingCart,
        unselectedIcon= Icons.Outlined.ShoppingCart,
        hasNews = true,
        badges=1
    ),

    BottomNavItem(
        title = "Profile",
        route="profile",
        selectedIcon= Icons.Filled.Person,
        unselectedIcon= Icons.Outlined.Person,
        hasNews = true,
        badges=0
    ),



    )



data class BottomNavItem(
    val title :String,
    val route :String,
    val selectedIcon: ImageVector,
    val unselectedIcon : ImageVector,
    val hasNews :Boolean,
    val badges :Int
)



@Composable
@Preview(showBackground = true)
fun ClimateScreenPreview(){
    ClimateScreen(rememberNavController())}

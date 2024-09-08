
package com.example.greenlife.ui.theme.screens.soiltype

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import com.example.greenlife.navigation.ROUT_CROPTYPE
import com.example.greenlife.ui.theme.green


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SoiltypeScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            ) {

        var selected by remember { mutableIntStateOf(0) }
        Scaffold (
            bottomBar = {
                NavigationBar(
                    containerColor = Color.Green,
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
                        text = "Soil Types",
                        fontSize = 30.sp,
                        fontFamily = FontFamily.Cursive,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(30.dp))

                    //Volcanic soil
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
                               Image(painter = painterResource(id = R.drawable.volacnicsoil),
                                   contentDescription = "volcanicsoil",
                                   modifier = Modifier.fillMaxSize(),
                                   contentScale = ContentScale.Crop)

                           }
                        }
                        Spacer(modifier = Modifier.height(10.dp))


                        Text(
                            text = "Volcanic Soil",
                            fontSize = 25.sp,
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Center,

                            )
                        Text(text = "Soil Ph : 5.0 - 6.0 (Acidic)", textAlign = TextAlign.Right)
                        Text(text = "Porosity : 50% - 70%", textAlign = TextAlign.Right)
                        Text(text = "Mineral Composition : Non crystalline", textAlign = TextAlign.Right)


                    }
                    Spacer(modifier = Modifier.height(50.dp))

                    //Alluvial soil
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
                                Image(painter = painterResource(id = R.drawable.alluviumsoil),
                                    contentDescription = "alluviumsoil",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop)

                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "Alluvial Soil",
                            fontSize = 25.sp,
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Center,

                            )
                        Text(text = "Soil Ph : 6.0 - 8.0 (Slightly Acidic)", textAlign = TextAlign.Right)
                        Text(text = "Porosity : 30% - 50%", textAlign = TextAlign.Right)
                        Text(text = "Mineral Composition : Slightly crystalline", textAlign = TextAlign.Right)


                    }
                    Spacer(modifier = Modifier.height(50.dp))

                    //Black Cotton
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
                                Image(painter = painterResource(id = R.drawable.blackcottonsoil),
                                    contentDescription = "home",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop)

                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "Black Cotton Soil",
                            fontSize = 25.sp,
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Right,

                            )
                        Text(text = "Soil Ph : 8.0 - 9.0 (Basic)", textAlign = TextAlign.Right)
                        Text(text = "Porosity : 40% - 60%", textAlign = TextAlign.Right)
                        Text(text = "Mineral Composition : Crystalline", textAlign = TextAlign.Right)

                    }

                    Spacer(modifier = Modifier.height(50.dp))

                    //Sand Soil

                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 10.dp),

                        ){

                        Box(modifier = Modifier
                            .height(180.dp)
                            .fillMaxWidth(),
                            contentAlignment = Alignment.Center) {

                            Card {

                                Image(painter = painterResource(id = R.drawable.sandsoil),
                                    contentDescription = "home",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop)
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "Sand Soil",
                            fontSize = 25.sp,
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Right,

                            )
                        Text(text = "Soil Ph : 5.5 - 7.0 (slightly Acidic)", textAlign = TextAlign.Right)
                        Text(text = "Porosity : 30% - 50%", textAlign = TextAlign.Right)
                        Text(text = "Mineral Composition : Crystalline", textAlign = TextAlign.Right)

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
fun SoiltypeScreenPreview(){
    SoiltypeScreen(rememberNavController())}

package com.example.greenlife.ui.theme.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.greenlife.R
import com.example.greenlife.navigation.ROUT_CLIMATE
import com.example.greenlife.navigation.ROUT_CROPTYPE
import com.example.greenlife.navigation.ROUT_SOILTYPE
import com.example.greenlife.ui.theme.green


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController){
    Column(modifier = Modifier
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
                    title = { Text(text = "Greenlife", color = Color.White) },
                    colors = TopAppBarDefaults.mediumTopAppBarColors(green),
                    )
            },



            //Content Section
            content = @Composable{


                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 60.dp, bottom = 100.dp)
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(
                        painter = painterResource(id = R.drawable.leaficon),
                        contentDescription = "home",
                        modifier = Modifier
                            .size(180.dp),
                        contentScale = ContentScale.Crop
                    )


                    Text(
                        text = "We Grow Together",
                        fontSize = 20.sp,
                        fontFamily = FontFamily.Cursive,
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    //soil type
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 5.dp, end = 5.dp)

                    ){

                        Box(modifier = Modifier
                            .height(180.dp)
                            .fillMaxWidth(),
                            contentAlignment = Alignment.Center) {


                               Card {
                                   Image(painter = painterResource(id = R.drawable.genericsoil),
                                       contentDescription = "home",
                                       modifier = Modifier.fillMaxSize(),
                                       contentScale = ContentScale.Crop)


                               }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Button(
                            onClick = { navController.navigate(ROUT_SOILTYPE) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
                            colors = ButtonDefaults.buttonColors(green),
                            shape = RoundedCornerShape(15.dp)
                        ) {
                            Text(text = "Soil Type")

                        }

                    }
                    Spacer(modifier = Modifier.height(50.dp))


                    //Crop type

                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 5.dp, end = 5.dp)

                    ){

                        Box(modifier = Modifier
                            .height(180.dp)
                            .fillMaxWidth(),
                            contentAlignment = Alignment.Center) {

                          Card {
                              Image(painter = painterResource(id = R.drawable.genericcrops),
                                  contentDescription = "home",
                                  modifier = Modifier.fillMaxSize(),
                                  contentScale = ContentScale.Crop)

                          }
                        }
                        Spacer(modifier = Modifier.height(10.dp))

                        Button(
                            onClick = { navController.navigate(ROUT_CROPTYPE) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
                            colors = ButtonDefaults.buttonColors(green),
                            shape = RoundedCornerShape(15.dp)
                        ) {
                            Text(text = "Crop Type")

                        }

                    }

                    Spacer(modifier = Modifier.height(50.dp))

                    //Climate

                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 5.dp, end = 5.dp)

                    ){

                        Box(modifier = Modifier
                            .height(180.dp)
                            .fillMaxWidth(),
                            contentAlignment = Alignment.Center) {

                           Card {
                               Image(painter = painterResource(id = R.drawable.genericclimate),
                                   contentDescription = "genericclimate",
                                   modifier = Modifier.fillMaxSize(),
                                   contentScale = ContentScale.Crop)

                           }
                        }
                        Spacer(modifier = Modifier.height(10.dp))

                        Button(
                            onClick = { navController.navigate(ROUT_CLIMATE) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
                            colors = ButtonDefaults.buttonColors(green),
                            shape = RoundedCornerShape(15.dp)
                        ) {
                            Text(text = "Climate")

                        }

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
        route="shop",
        selectedIcon= Icons.Filled.ShoppingCart,
        unselectedIcon= Icons.Outlined.ShoppingCart,
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
fun HomeScreenPreview(){
    HomeScreen(rememberNavController())}
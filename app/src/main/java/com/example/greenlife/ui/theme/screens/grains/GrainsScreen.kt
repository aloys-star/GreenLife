package com.example.greenlife.ui.theme.screens.grains

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.greenlife.R
import com.example.greenlife.navigation.ROUT_ADDCROP
import com.example.greenlife.navigation.ROUT_CLIMATE
import com.example.greenlife.navigation.ROUT_SOILTYPE
import com.example.greenlife.ui.theme.green


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun GrainsScreen(navController: NavController){
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


            floatingActionButton = {
                FloatingActionButton(
                    onClick = { /*TODO*/ },
                    containerColor = Color.LightGray
                ) {
                    IconButton(onClick = {
                        navController.navigate(ROUT_ADDCROP)
                    }) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "menu"
                        )
                    }
                }
            },
            //Content Section
            content = @Composable {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 60.dp, bottom = 100.dp, start = 5.dp, end = 5.dp)
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally,

                ){
                    Spacer(modifier = Modifier.height(40.dp))

                    Text(
                        text = "Grains",
                        fontSize = 30.sp,
                        fontFamily = FontFamily.Cursive,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(30.dp))

                    //Grain 1

                    Card (modifier = Modifier
                        .height(250.dp)
                        .width(370.dp)
                    ) {

                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.maize),
                                contentDescription = "null",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )


                            Row(modifier = Modifier.align(Alignment.BottomStart)) {
                                Column(
                                    modifier = Modifier
                                        .background(
                                            brush = Brush.verticalGradient(
                                                colors = listOf(
                                                    Color.Transparent,
                                                    Color.Black
                                                )
                                            )
                                        )
                                        .fillMaxWidth()
                                        .padding(7.dp)
                                ) {

                                    Text(
                                        text = "Maize",
                                        fontSize = 28.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        fontFamily = FontFamily.Default,
                                        color = Color.White
                                    )


                                    Text(
                                        text = "Soil Type : volcanic soil",
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Medium,
                                        fontFamily = FontFamily.Default,
                                        color = Color.White,
                                        modifier = Modifier.clickable { navController.navigate(
                                            ROUT_SOILTYPE
                                        ) }

                                    )

                                    Spacer(modifier = Modifier.height(5.dp))

                                    Text(
                                        text = "Climate : Temprate",
                                        fontSize = 19.sp,
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = FontFamily.Default,
                                        color = Color.White,
                                        modifier = Modifier.clickable { navController.navigate(
                                            ROUT_CLIMATE
                                        ) }
                                    )




                                }
                            }

                        }
                    }

                    Spacer(modifier = Modifier.height(30.dp))


                    //End of Grain 1

                    //Grain 2

                    Card (modifier = Modifier
                        .height(250.dp)
                        .width(370.dp)
                    ) {

                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.lentils),
                                contentDescription = "null",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )


                            Row(modifier = Modifier.align(Alignment.BottomStart)) {
                                Column(
                                    modifier = Modifier
                                        .background(
                                            brush = Brush.verticalGradient(
                                                colors = listOf(
                                                    Color.Transparent,
                                                    Color.Black
                                                )
                                            )
                                        )
                                        .fillMaxWidth()
                                        .padding(7.dp)
                                ) {

                                    Text(
                                        text = "Lentils",
                                        fontSize = 28.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        fontFamily = FontFamily.Default,
                                        color = Color.White
                                    )


                                    Text(
                                        text = "Soil Type : Alluvial soil",
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Medium,
                                        fontFamily = FontFamily.Default,
                                        color = Color.White,
                                        modifier = Modifier.clickable { navController.navigate(
                                            ROUT_SOILTYPE
                                        ) }

                                    )

                                    Spacer(modifier = Modifier.height(5.dp))

                                    Text(
                                        text = "Climate : Temprate",
                                        fontSize = 19.sp,
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = FontFamily.Default,
                                        color = Color.White,
                                        modifier = Modifier.clickable { navController.navigate(
                                            ROUT_CLIMATE
                                        ) }
                                    )




                                }
                            }

                        }
                    }

                    Spacer(modifier = Modifier.height(30.dp))

                    //End of Grain 2


                    //Grain 3

                    Card (modifier = Modifier
                        .height(250.dp)
                        .width(370.dp)
                    ) {

                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.sorghum),
                                contentDescription = "null",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )


                            Row(modifier = Modifier.align(Alignment.BottomStart)) {
                                Column(
                                    modifier = Modifier
                                        .background(
                                            brush = Brush.verticalGradient(
                                                colors = listOf(
                                                    Color.Transparent,
                                                    Color.Black
                                                )
                                            )
                                        )
                                        .fillMaxWidth()
                                        .padding(7.dp)
                                ) {

                                    Text(
                                        text = "Sorghum",
                                        fontSize = 28.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        fontFamily = FontFamily.Default,
                                        color = Color.White
                                    )


                                    Text(
                                        text = "Soil Type : volcanic soil",
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Medium,
                                        fontFamily = FontFamily.Default,
                                        color = Color.White,
                                        modifier = Modifier.clickable { navController.navigate(
                                            ROUT_SOILTYPE
                                        ) }

                                    )

                                    Spacer(modifier = Modifier.height(5.dp))

                                    Text(
                                        text = "Climate : Semi- Arid and Temprate",
                                        fontSize = 19.sp,
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = FontFamily.Default,
                                        color = Color.White,
                                        modifier = Modifier.clickable { navController.navigate(
                                            ROUT_CLIMATE
                                        ) }
                                    )




                                }
                            }

                        }
                    }

                    Spacer(modifier = Modifier.height(30.dp))


                    //End of Grain 3

                    //Grain4

                    Card (modifier = Modifier
                        .height(250.dp)
                        .width(370.dp)
                    ) {

                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.wheat),
                                contentDescription = "null",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )


                            Row(modifier = Modifier.align(Alignment.BottomStart)) {
                                Column(
                                    modifier = Modifier
                                        .background(
                                            brush = Brush.verticalGradient(
                                                colors = listOf(
                                                    Color.Transparent,
                                                    Color.Black
                                                )
                                            )
                                        )
                                        .fillMaxWidth()
                                        .padding(7.dp)
                                ) {

                                    Text(
                                        text = "Wheat",
                                        fontSize = 28.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        fontFamily = FontFamily.Default,
                                        color = Color.White
                                    )


                                    Text(
                                        text = "Soil Type : volcanic soil",
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Medium,
                                        fontFamily = FontFamily.Default,
                                        color = Color.White,
                                        modifier = Modifier.clickable { navController.navigate(
                                            ROUT_SOILTYPE
                                        ) }

                                    )

                                    Spacer(modifier = Modifier.height(5.dp))

                                    Text(
                                        text = "Climate : Semi- Arid and Temprate",
                                        fontSize = 19.sp,
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = FontFamily.Default,
                                        color = Color.White,
                                        modifier = Modifier.clickable { navController.navigate(
                                            ROUT_CLIMATE
                                        ) }
                                    )




                                }
                            }

                        }
                    }

                    Spacer(modifier = Modifier.height(30.dp))


                    //End of Grain 4

                    //Grain 5

                    Card (modifier = Modifier
                        .height(250.dp)
                        .width(370.dp)
                    ) {

                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.rice),
                                contentDescription = "null",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )


                            Row(modifier = Modifier.align(Alignment.BottomStart)) {
                                Column(
                                    modifier = Modifier
                                        .background(
                                            brush = Brush.verticalGradient(
                                                colors = listOf(
                                                    Color.Transparent,
                                                    Color.Black
                                                )
                                            )
                                        )
                                        .fillMaxWidth()
                                        .padding(7.dp)
                                ) {

                                    Text(
                                        text = "Rice",
                                        fontSize = 28.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        fontFamily = FontFamily.Default,
                                        color = Color.White
                                    )


                                    Text(
                                        text = "Soil Type : Black Cotton Soil",
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Medium,
                                        fontFamily = FontFamily.Default,
                                        color = Color.White,
                                        modifier = Modifier.clickable { navController.navigate(
                                            ROUT_SOILTYPE
                                        ) }

                                    )

                                    Spacer(modifier = Modifier.height(5.dp))

                                    Text(
                                        text = "Climate : Equatorial and Temprate",
                                        fontSize = 19.sp,
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = FontFamily.Default,
                                        color = Color.White,
                                        modifier = Modifier.clickable { navController.navigate(
                                            ROUT_CLIMATE
                                        ) }
                                    )




                                }
                            }

                        }
                    }

                    Spacer(modifier = Modifier.height(30.dp))


                    //End of Grain 5


                    //Grain 6

                    Card (modifier = Modifier
                        .height(250.dp)
                        .width(370.dp)
                    ) {

                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.oats),
                                contentDescription = "null",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )


                            Row(modifier = Modifier.align(Alignment.BottomStart)) {
                                Column(
                                    modifier = Modifier
                                        .background(
                                            brush = Brush.verticalGradient(
                                                colors = listOf(
                                                    Color.Transparent,
                                                    Color.Black
                                                )
                                            )
                                        )
                                        .fillMaxWidth()
                                        .padding(7.dp)
                                ) {

                                    Text(
                                        text = "Oats",
                                        fontSize = 28.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        fontFamily = FontFamily.Default,
                                        color = Color.White
                                    )


                                    Text(
                                        text = "Soil Type : Volcanic Soil",
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Medium,
                                        fontFamily = FontFamily.Default,
                                        color = Color.White,
                                        modifier = Modifier.clickable { navController.navigate(
                                            ROUT_SOILTYPE
                                        ) }

                                    )

                                    Spacer(modifier = Modifier.height(5.dp))

                                    Text(
                                        text = "Climate : Semi-arid and Temprate",
                                        fontSize = 19.sp,
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = FontFamily.Default,
                                        color = Color.White,
                                        modifier = Modifier.clickable { navController.navigate(
                                            ROUT_CLIMATE
                                        ) }
                                    )




                                }
                            }

                        }
                    }

                    Spacer(modifier = Modifier.height(30.dp))


                    //End of Grain 6

                    //Grain 7

                    Card (modifier = Modifier
                        .height(250.dp)
                        .width(370.dp)
                    ) {

                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.beans),
                                contentDescription = "null",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )


                            Row(modifier = Modifier.align(Alignment.BottomStart)) {
                                Column(
                                    modifier = Modifier
                                        .background(
                                            brush = Brush.verticalGradient(
                                                colors = listOf(
                                                    Color.Transparent,
                                                    Color.Black
                                                )
                                            )
                                        )
                                        .fillMaxWidth()
                                        .padding(7.dp)
                                ) {

                                    Text(
                                        text = "Beans",
                                        fontSize = 28.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        fontFamily = FontFamily.Default,
                                        color = Color.White
                                    )


                                    Text(
                                        text = "Soil Type : Volcanic Soil",
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Medium,
                                        fontFamily = FontFamily.Default,
                                        color = Color.White,
                                        modifier = Modifier.clickable { navController.navigate(
                                            ROUT_SOILTYPE
                                        ) }

                                    )

                                    Spacer(modifier = Modifier.height(5.dp))

                                    Text(
                                        text = "Climate : Semi-arid and Temprate",
                                        fontSize = 19.sp,
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = FontFamily.Default,
                                        color = Color.White,
                                        modifier = Modifier.clickable { navController.navigate(
                                            ROUT_CLIMATE
                                        ) }
                                    )




                                }
                            }

                        }
                    }

                    Spacer(modifier = Modifier.height(30.dp))


                    //End of Grain 7



















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
fun GrainsScreenPreview(){
    GrainsScreen(rememberNavController())}

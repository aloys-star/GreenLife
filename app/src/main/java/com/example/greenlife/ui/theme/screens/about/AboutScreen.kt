package com.example.greenlife.ui.theme.screens.about

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.Image
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.greenlife.R
import com.example.greenlife.ui.theme.green
import com.example.greenlife.ui.theme.greenyellow


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AboutScreen(navController: NavController){
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
                        .padding(top = 60.dp, bottom = 80.dp, start = 5.dp, end = 10.dp)
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
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1050.dp)
                            .padding(bottom = 20.dp),
                        shape = RoundedCornerShape(topStart = 60.dp, topEnd = 60.dp, bottomEnd = 60.dp, bottomStart = 60.dp ),
                        colors = CardDefaults.cardColors(greenyellow)
                    ) {
                        Spacer(modifier = Modifier.height(40.dp))

                        Text(
                            text = "GreenLife app is designed to empower farmers by providing personalized, location-based agricultural advice.",
                            modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                            fontSize = 20.sp,
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Left,

                            )

                        Spacer(modifier = Modifier.height(10.dp))

                        Card(
                            modifier = Modifier
                                .height(200.dp)
                                .width(360.dp)
                                .padding(start = 10.dp, end = 10.dp),
                        ) {
                            Image(painter = painterResource(id = R.drawable.farmers1),
                                contentDescription = "tropicalclimate",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop,
                            )

                        }

                        Spacer(modifier = Modifier.height(10.dp))


                        Text(
                            text = "With our user-friendly interface, detailed crop information, and integration of climate and soil data, we help our users make informed decisions about the best crops to grow in different regions of Kenya. ",
                            modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                            fontSize = 20.sp,
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Left,

                            )

                        Spacer(modifier = Modifier.height(10.dp))

                        Card(
                            modifier = Modifier
                                .height(200.dp)
                                .width(360.dp)
                                .padding(start = 10.dp, end = 10.dp),
                        ) {
                            Image(painter = painterResource(id = R.drawable.farmers2),
                                contentDescription = "tropicalclimate",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop,
                            )

                        }

                        Spacer(modifier = Modifier.height(10.dp))


                        Text(
                            text = "We aim to boost agricultural productivity and sustainability by aligning local conditions with crop requirements.",
                            modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                            fontSize = 20.sp,
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Left,

                            )

                        Spacer(modifier = Modifier.height(20.dp))

                        var mContext = LocalContext.current


                        Button(
                            onClick = {
                                val shareIntent= Intent(Intent.ACTION_SEND)
                                shareIntent.type="text/plain"
                                shareIntent.putExtra(Intent.EXTRA_TEXT, "Download our app and begin your journey of growth today")
                                mContext.startActivity(Intent.createChooser(shareIntent, "Share"))
                            },
                            modifier = Modifier
                                .padding(start = 10.dp,).width(200.dp),
                            colors = ButtonDefaults.buttonColors(Color.Black),
                            shape = RoundedCornerShape(15.dp)
                        ) {
                            Text(text = "SHARE")
                        }


                        Button(
                            onClick = {
                                val callIntent= Intent(Intent.ACTION_DIAL)
                                callIntent.data="tel:0720245837".toUri()
                                mContext.startActivity(callIntent)

                            },
                            modifier = Modifier.padding(start = 10.dp).width(200.dp),
                            colors = ButtonDefaults.buttonColors(Color.Black),
                            shape = RoundedCornerShape(15.dp)
                        ) {
                            Text(text = "Contact Us")

                        }

                        Text(
                            text = "Email : info@GreenLife.com",
                            modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                            fontSize = 15.sp,
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Left,

                            )

                        Text(
                            text = "Phone : +254 786 635 957",
                            modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                            fontSize = 15.sp,
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Left,

                            )
                        Text(
                            text = "2024 GreenLife. All Rights Reserved",
                            modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                            fontSize = 15.sp,
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Left,

                            )







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
fun AboutScreenPreview(){
    AboutScreen(rememberNavController())}


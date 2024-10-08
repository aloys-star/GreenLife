package com.example.greenlife.ui.theme.screens.shop

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
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
fun ShopScreen(navController: NavController){
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
                        .padding(top = 70.dp, bottom = 100.dp, start = 5.dp, end = 10.dp)
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally

                    ){
                    Spacer(modifier = Modifier.height(30.dp))


                    Text(
                        text = "Shop",
                        fontSize = 30.sp,
                        fontFamily = FontFamily.Cursive,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(30.dp))


                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1100.dp),
                        shape = RoundedCornerShape(topStart = 60.dp, topEnd = 60.dp, bottomEnd = 60.dp, bottomStart = 60.dp ),
                        colors = CardDefaults.cardColors(greenyellow)
                    ) {
                        Text(
                            text = "Fertilizers",
                            fontSize = 25.sp,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                        )
                        

                        //Row1
                        Row {
                            Card(
                                modifier = Modifier.padding(
                                    top = 10.dp,
                                    start = 10.dp,
                                    end = 10.dp
                                )
                            ) {
                                Box(
                                    modifier = Modifier
                                        .height(180.dp)
                                        .width(140.dp),
                                    contentAlignment = Alignment.Center
                                ) {

                                    Image(
                                        painter = painterResource(id = R.drawable.nitrogenfertilizer),
                                        contentDescription = "home",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Favorite,
                                        contentDescription = "favourite",
                                        modifier = Modifier
                                            .align(Alignment.TopStart)
                                            .padding(10.dp),
                                        tint = Color.Black
                                    )


                                }

                            }
                            Column(modifier = Modifier.padding(start = 10.dp, top = 10.dp)) {
                                Text(text = "Nitrogen fertilizer", fontSize = 20.sp)
                                Text(text = "Brand : Milorgranite")
                                Row {
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )

                                }

                                Text(text = "14,400 Reviews")
                                Text(text = "Price : Ksh.1800")
                                Spacer(modifier = Modifier.height(10.dp))


                                val mContext = LocalContext.current
                                Button(
                                    onClick = {
                                        val callIntent= Intent(Intent.ACTION_DIAL)
                                        callIntent.data="tel:0720245837".toUri()
                                        mContext.startActivity(callIntent)

                                    },
                                    modifier = Modifier
                                        .padding(end = 10.dp)
                                        .fillMaxWidth()
                                        .height(50.dp),
                                    colors = ButtonDefaults.buttonColors(Color.Black),
                                    shape = RoundedCornerShape(15.dp)
                                ) {
                                    Text(text = "Call to Order")

                                }
                            }


                        }

                        Spacer(modifier = Modifier.height(15.dp))


                        //Row 2
                        Row {
                            Card(
                                modifier = Modifier.padding(
                                    top = 10.dp,
                                    start = 10.dp,
                                    end = 10.dp
                                )
                            ) {
                                Box(
                                    modifier = Modifier
                                        .height(180.dp)
                                        .width(140.dp),
                                    contentAlignment = Alignment.Center
                                ) {

                                    Image(
                                        painter = painterResource(id = R.drawable.phosphorusfertilizer),
                                        contentDescription = "home",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop
                                    )



                                }

                            }
                            Column(modifier = Modifier.padding(start = 10.dp, top = 10.dp)) {
                                Text(text = "Phosphorus fertilizer", fontSize = 20.sp)
                                Text(text = "Brand : Falcon")
                                Row {
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )

                                }

                                Text(text = "10,200 Reviews")
                                Text(text = "Price : Ksh.2100")
                                Spacer(modifier = Modifier.height(10.dp))


                                val mContext = LocalContext.current
                                Button(
                                    onClick = {
                                        val callIntent= Intent(Intent.ACTION_DIAL)
                                        callIntent.data="tel:0720245837".toUri()
                                        mContext.startActivity(callIntent)

                                    },
                                    modifier = Modifier
                                        .padding(end = 10.dp)
                                        .fillMaxWidth()
                                        .height(50.dp),
                                    colors = ButtonDefaults.buttonColors(Color.Black),
                                    shape = RoundedCornerShape(15.dp)
                                ) {
                                    Text(text = "Call to Order")

                                }
                            }


                        }
                        Spacer(modifier = Modifier.height(15.dp))


                        //Row 3
                        Row {
                            Card(
                                modifier = Modifier.padding(
                                    top = 10.dp,
                                    start = 10.dp,
                                    end = 10.dp
                                )
                            ) {
                                Box(
                                    modifier = Modifier
                                        .height(180.dp)
                                        .width(140.dp),
                                    contentAlignment = Alignment.Center
                                ) {

                                    Image(
                                        painter = painterResource(id = R.drawable.potasuimfertilizer),
                                        contentDescription = "home",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop
                                    )



                                }

                            }
                            Column(modifier = Modifier.padding(start = 10.dp, top = 10.dp)) {
                                Text(text = "Potassium fertilizer", fontSize = 20.sp)
                                Text(text = "Brand : Thabiti")
                                Row {
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )

                                }

                                Text(text = "9,800 Reviews")
                                Text(text = "Price : Ksh.1900")
                                Spacer(modifier = Modifier.height(10.dp))


                                val mContext = LocalContext.current
                                Button(
                                    onClick = {
                                        val callIntent= Intent(Intent.ACTION_DIAL)
                                        callIntent.data="tel:0720245837".toUri()
                                        mContext.startActivity(callIntent)

                                    },
                                    modifier = Modifier
                                        .padding(end = 10.dp)
                                        .fillMaxWidth()
                                        .height(50.dp),
                                    colors = ButtonDefaults.buttonColors(Color.Black),
                                    shape = RoundedCornerShape(15.dp)
                                ) {
                                    Text(text = "Call to Order")

                                }
                            }


                        }

                        Spacer(modifier = Modifier.height(15.dp))


                        //Row 4
                        Row {
                            Card(
                                modifier = Modifier.padding(
                                    top = 10.dp,
                                    start = 10.dp,
                                    end = 10.dp
                                )
                            ) {
                                Box(
                                    modifier = Modifier
                                        .height(180.dp)
                                        .width(140.dp),
                                    contentAlignment = Alignment.Center
                                ) {

                                    Image(
                                        painter = painterResource(id = R.drawable.organicfertilizers),
                                        contentDescription = "organicfertilizer",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop
                                    )



                                }

                            }
                            Column(modifier = Modifier.padding(start = 10.dp, top = 10.dp)) {
                                Text(text = "Organic fertilizer", fontSize = 20.sp)
                                Text(text = "Brand : Evergrow")
                                Row {
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )

                                }

                                Text(text = "10,580 Reviews")
                                Text(text = "Price : Ksh.2400")
                                Spacer(modifier = Modifier.height(10.dp))


                                val mContext = LocalContext.current
                                Button(
                                    onClick = {
                                        val callIntent= Intent(Intent.ACTION_DIAL)
                                        callIntent.data="tel:0720245837".toUri()
                                        mContext.startActivity(callIntent)

                                    },
                                    modifier = Modifier
                                        .padding(end = 10.dp)
                                        .fillMaxWidth()
                                        .height(50.dp),
                                    colors = ButtonDefaults.buttonColors(Color.Black),
                                    shape = RoundedCornerShape(15.dp)
                                ) {
                                    Text(text = "Call to Order")

                                }
                            }


                        }

                        Spacer(modifier = Modifier.height(15.dp))

                        //Row 5
                        Row {
                            Card(
                                modifier = Modifier.padding(
                                    top = 10.dp,
                                    start = 10.dp,
                                    end = 10.dp
                                )
                            ) {
                                Box(
                                    modifier = Modifier
                                        .height(180.dp)
                                        .width(140.dp),
                                    contentAlignment = Alignment.Center
                                ) {

                                    Image(
                                        painter = painterResource(id = R.drawable.micronutrientfertilizer),
                                        contentDescription = "micronutrientfertilizer",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop
                                    )



                                }

                            }
                            Column(modifier = Modifier.padding(start = 10.dp, top = 10.dp)) {
                                Text(text = "Micronutrient fertilizer", fontSize = 20.sp)
                                Text(text = "Brand : Amiran")
                                Row {
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )

                                }

                                Text(text = "6,970 Reviews")
                                Text(text = "Price : Ksh.1700")
                                Spacer(modifier = Modifier.height(10.dp))


                                val mContext = LocalContext.current
                                Button(
                                    onClick = {
                                        val callIntent= Intent(Intent.ACTION_DIAL)
                                        callIntent.data="tel:0720245837".toUri()
                                        mContext.startActivity(callIntent)

                                    },
                                    modifier = Modifier
                                        .padding(end = 10.dp)
                                        .fillMaxWidth()
                                        .height(50.dp),
                                    colors = ButtonDefaults.buttonColors(Color.Black),
                                    shape = RoundedCornerShape(15.dp)
                                ) {
                                    Text(text = "Call to Order")

                                }
                            }


                        }



                        
                    }

                    Spacer(modifier = Modifier.height(30.dp))


                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1100.dp),
                        shape = RoundedCornerShape(topStart = 60.dp, topEnd = 60.dp, bottomEnd = 60.dp, bottomStart = 60.dp ),
                        colors = CardDefaults.cardColors(greenyellow)
                    ) {
                        Text(
                            text = "Seeds",
                            fontSize = 25.sp,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                        )


                        //Row1
                        Row {
                            Card(
                                modifier = Modifier.padding(
                                    top = 10.dp,
                                    start = 10.dp,
                                    end = 10.dp
                                )
                            ) {
                                Box(
                                    modifier = Modifier
                                        .height(180.dp)
                                        .width(140.dp),
                                    contentAlignment = Alignment.Center
                                ) {

                                    Image(
                                        painter = painterResource(id = R.drawable.cabbage),
                                        contentDescription = "cabbage",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Favorite,
                                        contentDescription = "favourite",
                                        modifier = Modifier
                                            .align(Alignment.TopStart)
                                            .padding(10.dp),
                                        tint = Color.Black
                                    )


                                }

                            }
                            Column(modifier = Modifier.padding(start = 10.dp, top = 10.dp)) {
                                Text(text = "Cabbage seeds", fontSize = 20.sp)
                                Text(text = "Brand : Simlaw Seeds")
                                Row {
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )

                                }

                                Text(text = "1,500 Reviews")
                                Text(text = "Price : Ksh.400 per Kg")
                                Spacer(modifier = Modifier.height(10.dp))


                                val mContext = LocalContext.current
                                Button(
                                    onClick = {
                                        val callIntent= Intent(Intent.ACTION_DIAL)
                                        callIntent.data="tel:0720245837".toUri()
                                        mContext.startActivity(callIntent)

                                    },
                                    modifier = Modifier
                                        .padding(end = 10.dp)
                                        .fillMaxWidth()
                                        .height(50.dp),
                                    colors = ButtonDefaults.buttonColors(Color.Black),
                                    shape = RoundedCornerShape(15.dp)
                                ) {
                                    Text(text = "Call to Order")

                                }
                            }


                        }

                        Spacer(modifier = Modifier.height(15.dp))


                        //Row 2
                        Row {
                            Card(
                                modifier = Modifier.padding(
                                    top = 10.dp,
                                    start = 10.dp,
                                    end = 10.dp
                                )
                            ) {
                                Box(
                                    modifier = Modifier
                                        .height(180.dp)
                                        .width(140.dp),
                                    contentAlignment = Alignment.Center
                                ) {

                                    Image(
                                        painter = painterResource(id = R.drawable.maize),
                                        contentDescription = "maize",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop
                                    )



                                }

                            }
                            Column(modifier = Modifier.padding(start = 10.dp, top = 10.dp)) {
                                Text(text = "Maize seeds", fontSize = 20.sp)
                                Text(text = "Brand : Simlaw seeds")
                                Row {
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )

                                }

                                Text(text = "1,780 Reviews")
                                Text(text = "Price : Ksh.200 per Kg")
                                Spacer(modifier = Modifier.height(10.dp))


                                val mContext = LocalContext.current
                                Button(
                                    onClick = {
                                        val callIntent= Intent(Intent.ACTION_DIAL)
                                        callIntent.data="tel:0720245837".toUri()
                                        mContext.startActivity(callIntent)

                                    },
                                    modifier = Modifier
                                        .padding(end = 10.dp)
                                        .fillMaxWidth()
                                        .height(50.dp),
                                    colors = ButtonDefaults.buttonColors(Color.Black),
                                    shape = RoundedCornerShape(15.dp)
                                ) {
                                    Text(text = "Call to Order")

                                }
                            }


                        }
                        Spacer(modifier = Modifier.height(15.dp))


                        //Row 3
                        Row {
                            Card(
                                modifier = Modifier.padding(
                                    top = 10.dp,
                                    start = 10.dp,
                                    end = 10.dp
                                )
                            ) {
                                Box(
                                    modifier = Modifier
                                        .height(180.dp)
                                        .width(140.dp),
                                    contentAlignment = Alignment.Center
                                ) {

                                    Image(
                                        painter = painterResource(id = R.drawable.tomato),
                                        contentDescription = "tomatoe",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop
                                    )



                                }

                            }
                            Column(modifier = Modifier.padding(start = 10.dp, top = 10.dp)) {
                                Text(text = "Tomato seeds", fontSize = 20.sp)
                                Text(text = "Brand : Kenya seed company")
                                Row {
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )

                                }

                                Text(text = "3,290 Reviews")
                                Text(text = "Price : Ksh.800 per Kg")
                                Spacer(modifier = Modifier.height(10.dp))


                                val mContext = LocalContext.current
                                Button(
                                    onClick = {
                                        val callIntent= Intent(Intent.ACTION_DIAL)
                                        callIntent.data="tel:0720245837".toUri()
                                        mContext.startActivity(callIntent)

                                    },
                                    modifier = Modifier
                                        .padding(end = 10.dp)
                                        .fillMaxWidth()
                                        .height(50.dp),
                                    colors = ButtonDefaults.buttonColors(Color.Black),
                                    shape = RoundedCornerShape(15.dp)
                                ) {
                                    Text(text = "Call to Order")

                                }
                            }


                        }

                        Spacer(modifier = Modifier.height(15.dp))


                        //Row 4
                        Row {
                            Card(
                                modifier = Modifier.padding(
                                    top = 10.dp,
                                    start = 10.dp,
                                    end = 10.dp
                                )
                            ) {
                                Box(
                                    modifier = Modifier
                                        .height(180.dp)
                                        .width(140.dp),
                                    contentAlignment = Alignment.Center
                                ) {

                                    Image(
                                        painter = painterResource(id = R.drawable.skumawiki),
                                        contentDescription = "skumawiki",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop
                                    )



                                }

                            }
                            Column(modifier = Modifier.padding(start = 10.dp, top = 10.dp)) {
                                Text(text = "Kale seeds", fontSize = 20.sp)
                                Text(text = "Brand : Kenya seed company")
                                Row {
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )

                                }

                                Text(text = "880 Reviews")
                                Text(text = "Price : Ksh.700 per Kg")
                                Spacer(modifier = Modifier.height(10.dp))


                                val mContext = LocalContext.current
                                Button(
                                    onClick = {
                                        val callIntent= Intent(Intent.ACTION_DIAL)
                                        callIntent.data="tel:0720245837".toUri()
                                        mContext.startActivity(callIntent)

                                    },
                                    modifier = Modifier
                                        .padding(end = 10.dp)
                                        .fillMaxWidth()
                                        .height(50.dp),
                                    colors = ButtonDefaults.buttonColors(Color.Black),
                                    shape = RoundedCornerShape(15.dp)
                                ) {
                                    Text(text = "Call to Order")

                                }
                            }


                        }

                        Spacer(modifier = Modifier.height(15.dp))

                        //Row 5
                        Row {
                            Card(
                                modifier = Modifier.padding(
                                    top = 10.dp,
                                    start = 10.dp,
                                    end = 10.dp
                                )
                            ) {
                                Box(
                                    modifier = Modifier
                                        .height(180.dp)
                                        .width(140.dp),
                                    contentAlignment = Alignment.Center
                                ) {

                                    Image(
                                        painter = painterResource(id = R.drawable.chillies),
                                        contentDescription = "chillies",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop
                                    )



                                }

                            }
                            Column(modifier = Modifier.padding(start = 10.dp, top = 10.dp)) {
                                Text(text = "Pepper seeds", fontSize = 20.sp)
                                Text(text = "Brand : Simlaw")
                                Row {
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Black,
                                        modifier = Modifier.size(35.dp)
                                    )

                                }

                                Text(text = "5,970 Reviews")
                                Text(text = "Price : Ksh.700 per Kg")
                                Spacer(modifier = Modifier.height(10.dp))


                                val mContext = LocalContext.current
                                Button(
                                    onClick = {
                                        val callIntent= Intent(Intent.ACTION_DIAL)
                                        callIntent.data="tel:0720245837".toUri()
                                        mContext.startActivity(callIntent)

                                    },
                                    modifier = Modifier
                                        .padding(end = 10.dp)
                                        .fillMaxWidth()
                                        .height(50.dp),
                                    colors = ButtonDefaults.buttonColors(Color.Black),
                                    shape = RoundedCornerShape(15.dp)
                                ) {
                                    Text(text = "Call to Order")

                                }
                            }


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
fun ShopScreenPreview(){
    ShopScreen(rememberNavController())}
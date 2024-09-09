package com.example.property.ui.theme.screens.products


import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Send
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
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.greenlife.data.CropViewModel
import com.example.greenlife.models.Crop
import com.example.greenlife.navigation.ROUT_ADDCROP
import com.example.greenlife.ui.theme.green
import com.example.property.ui.theme.screens.products.BottomNavItem



@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ViewCropScreen(navController:NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {

        var context = LocalContext.current
        var productRepository = CropViewModel(navController, context)


        val emptyProductState = remember { mutableStateOf(Crop("", "", "", "", "", "", "")) }
        var emptyProductsListState = remember { mutableStateListOf<Crop>() }

        var products = productRepository.allCrops(emptyProductState, emptyProductsListState)


        var selected by remember { mutableIntStateOf(0) }

        Scaffold(
            bottomBar = {
                NavigationBar(
                    containerColor = green,
                    contentColor = Color.Gray
                ) {
                    bottomNavItem.forEachIndexed { index, bottomNavItem ->
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
                                    Icon(
                                        imageVector =
                                        if (index == selected)
                                            bottomNavItem.selectedIcon
                                        else
                                            bottomNavItem.unselectedIcon,
                                        contentDescription = bottomNavItem.title
                                    )
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
                    colors = TopAppBarDefaults.mediumTopAppBarColors(green)
                )
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
                        .padding(top = 120.dp, bottom = 120.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Additional crops",
                        fontSize = 30.sp,
                        fontFamily = FontFamily.Cursive,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    LazyColumn {
                        items(products) {
                            CropItem(
                                name = it.name,
                                soiltype = it.soiltype,
                                temperature = it.temperature,
                                rainfall = it.rainfall,
                                phone = it.phone,
                                id = it.id,
                                navController = navController,
                                productRepository = productRepository,
                                productImage = it.imageUrl
                            )
                        }
                    }
                }


            }
        )


    }

}

val bottomNavItem = listOf(
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
            hasNews = false,
            badges=0
        ),

    BottomNavItem(
        title = "Shop",
        route="shop",
        selectedIcon= Icons.Filled.ShoppingCart,
        unselectedIcon= Icons.Outlined.ShoppingCart,
        hasNews = false,
        badges=0
    ),



    )





@Composable
fun CropItem(name:String, soiltype:String, temperature:String,rainfall:String,phone:String, id:String,
                navController:NavHostController,
                productRepository:CropViewModel, productImage:String) {

    //1 item
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(15.dp, top = 30.dp, end = 15.dp)) {
        Card (modifier = Modifier
            .height(250.dp)
            .width(370.dp)
        ) {
            Box (modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center) {
                Image(
                    painter = rememberAsyncImagePainter(productImage),
                    contentDescription = "null",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )


                Row (modifier = Modifier.align(Alignment.BottomStart)) {
                    Column (modifier = Modifier
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Black
                                )
                            )
                        )
                        .fillMaxWidth()
                        .padding(7.dp)) {
                        //details

                        Text(text = "Name : $name",
                            fontSize = 27.sp,
                            fontWeight = FontWeight.ExtraBold,
                            fontFamily = FontFamily.Default,
                            color = Color.White
                        )


                        Text(text = "Soil Type : $soiltype",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Medium,
                            fontFamily = FontFamily.Default,
                            color = Color.White
                        )

                        Spacer(modifier = Modifier.height(5.dp))

                        Text(text = "Temperature : $temperature degrees",
                            fontSize = 19.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Default,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.height(5.dp))


                        Text(text = "Rainfall : $rainfall mm",
                            fontSize = 19.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Default,
                            color = Color.White
                        )

                        val mContext = LocalContext.current

                        //button row
                        Row (
                            modifier = Modifier
                                .padding(bottom = 10.dp)
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                        ){

                            Row (
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.End
                            ){

                                IconButton(onClick = { productRepository.updateCrop(id) }) {
                                    Icon(imageVector = Icons.Default.Edit, contentDescription = "", tint = Color.White)
                                }

                                Spacer(modifier = Modifier.width(5.dp))

                                IconButton(onClick = { productRepository.deleteCrop(id) }) {
                                    Icon(imageVector = Icons.Default.Delete, contentDescription = "", tint = Color.White)
                                }


                            }

                        }
                        //end of button row


                        //end details

                    }
                }

            }
        }
        //end 1 item

    }
}





@Composable
@Preview(showBackground = true)
fun ViewCropScreenPreview(){

    ViewCropScreen(navController = rememberNavController())

}